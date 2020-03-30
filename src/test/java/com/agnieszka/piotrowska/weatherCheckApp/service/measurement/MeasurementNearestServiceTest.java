package com.agnieszka.piotrowska.weatherCheckApp.service.measurement;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementNearestDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementNearestRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.MeasurementNearestResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import static org.springframework.http.HttpMethod.GET;

@RunWith(SpringRunner.class)
@WebMvcTest(MeasurementNearestService.class)
class MeasurementNearestServiceTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    RestTemplate restTemplate;

    private MeasurementService testBean;

    @Autowired
    public void init() {
        testBean = new MeasurementService(null,
                new MeasurementNearestService(restTemplate), null);
    }

    @Test
    public void shouldReturnMeasurementNearestURL() {

        MeasurementNearestResponse measurementNearestResponse = new MeasurementNearestResponse();
        Mockito.when(restTemplate.exchange(
                "https://airapi.airly.eu/v2/measurement/nearest?indexType=AIRLY_CAQI&lat=50.062006&lng=19.940984&maxDistanceKM=3",
                GET,
                new HttpEntity<>(new HttpHeaders()),
                MeasurementNearestResponse.class))
                .thenReturn(new ResponseEntity<>(measurementNearestResponse, HttpStatus.OK));
        MeasurementNearestRequest request = MeasurementNearestRequest.builder()
                .indexType("AIRLY_CAQI")
                .lat(50.062006)
                .lng(19.940984)
                .maxDistanceKM(3)
                .build();
        MeasurementNearestDto resultExpected = new MeasurementNearestDto();
        MeasurementNearestDto result = testBean.getMeasurementNearest(request);
        Assert.assertEquals(resultExpected, result);
    }
    @Test
    public void shouldReturnNotFoundMeasurementNearest() {

        MeasurementNearestResponse measurementNearestResponse = new MeasurementNearestResponse();
        Mockito.when(restTemplate.exchange(
                "https://airapi.airly.eu/v2/measurement/nearest?indexType=AIRLY_CAQI&lat=52.062006&lng=10.940984&maxDistanceKM=3",
                GET,
                new HttpEntity<>(new HttpHeaders()),
                MeasurementNearestResponse.class))
                .thenReturn(new ResponseEntity<>(measurementNearestResponse, HttpStatus.NOT_FOUND));
        MeasurementNearestRequest request = MeasurementNearestRequest.builder()
                .indexType("AIRLY_CAQI")
                .lat(52.062006)
                .lng(10.940984)
                .maxDistanceKM(3)
                .build();
        MeasurementNearestDto resultExpected = new MeasurementNearestDto();
        MeasurementNearestDto result = testBean.getMeasurementNearest(request);
        Assert.assertEquals(resultExpected, result);
    }
}
