package com.agnieszka.piotrowska.weatherCheckApp.service.measurement;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementNearestDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementNearestRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.MeasurementNearestResponse;
import com.agnieszka.piotrowska.weatherCheckApp.parser.MeasurementNearestParser;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.http.HttpMethod.GET;

@RunWith(SpringRunner.class)
@WebMvcTest(MeasurementNearestService.class)
class MeasurementNearestServiceTest {

    @Mock //(answer = Answers.RETURNS_DEEP_STUBS)
    RestTemplate restTemplate;

    @MockBean
    @Qualifier("measurementNearestParser")
    private MeasurementNearestParser dtoParser;

    private MeasurementService testBean;

    @Autowired
    public void init() {
        testBean = new MeasurementService(null,
                new MeasurementNearestService(restTemplate, dtoParser), null);
    }

    @Test
    public void shouldReturnMeasurementNearestURL() {

        MeasurementNearestResponse measurementNearestResponse = new MeasurementNearestResponse();
        Mockito.when(restTemplate.exchange(
                eq("https://airapi.airly.eu/v2/measurements/nearest?indexType=AIRLY_CAQI&lat=50.062006&lng=19.940984&maxDistanceKM=3"),
                eq(GET),
                any(HttpEntity.class),
                eq(MeasurementNearestResponse.class)))
                .thenReturn(new ResponseEntity<>(measurementNearestResponse, HttpStatus.OK));

       Mockito.when(dtoParser.toDto(any(MeasurementNearestResponse[].class)))
               .thenReturn((List.of(MeasurementNearestDto.builder().build())));

        MeasurementNearestRequest request = MeasurementNearestRequest.builder()
                .indexType("AIRLY_CAQI")
                .lat(50.062006)
                .lng(19.940984)
                .maxDistanceKM(3)
                .build();
        List<MeasurementNearestDto> resultExpected = List.of(MeasurementNearestDto.builder().build());
        List<MeasurementNearestDto> result = testBean.getMeasurementNearest(request);
        Assert.assertEquals(resultExpected, result);
    }
    @Test
    public void shouldReturnNotFoundMeasurementNearest() {

        MeasurementNearestResponse measurementNearestResponse = new MeasurementNearestResponse();
        Mockito.when(restTemplate.exchange(
                eq("https://airapi.airly.eu/v2/measurements/nearest?indexType=AIRLY_CAQI&lat=52.062006&lng=10.940984&maxDistanceKM=3"),
                eq(GET),
                any(HttpEntity.class),
                eq(MeasurementNearestResponse.class)))
                .thenReturn(new ResponseEntity<>(measurementNearestResponse, HttpStatus.NOT_FOUND));
      Mockito.when(dtoParser.toDto(any(MeasurementNearestResponse[].class))).thenReturn((List.of(MeasurementNearestDto.builder().build())));

        MeasurementNearestRequest request = MeasurementNearestRequest.builder()
                .indexType("AIRLY_CAQI")
                .lat(52.062006)
                .lng(10.940984)
                .maxDistanceKM(3)
                .build();
        List<MeasurementNearestDto> resultExpected = List.of(MeasurementNearestDto.builder().build());
        List<MeasurementNearestDto> result = testBean.getMeasurementNearest(request);
        Assert.assertEquals(resultExpected, result);
    }
}
