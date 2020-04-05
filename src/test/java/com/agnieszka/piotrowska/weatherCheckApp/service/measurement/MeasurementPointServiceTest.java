package com.agnieszka.piotrowska.weatherCheckApp.service.measurement;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementPointDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementPointRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.MeasurementPointResponse;
import com.agnieszka.piotrowska.weatherCheckApp.parser.MeasurementPointParser;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.http.HttpMethod.GET;

@RunWith(SpringRunner.class)
@WebMvcTest(MeasurementPointService.class)
class MeasurementPointServiceTest {

    @Mock
    RestTemplate restTemplate;

    @MockBean
    @Qualifier("measurementPointParser")
    private MeasurementPointParser dtoParser;

    private MeasurementService testBean;

    @Autowired
    public void init(){
        testBean = new MeasurementService(null,
                null,new MeasurementPointService(restTemplate, dtoParser));
    }

    @Test
    void shouldReturnMeasurementPointURL() {
        MeasurementPointResponse measurementPointResponse = new MeasurementPointResponse();

        Mockito.when(restTemplate.exchange(
                eq("https://airapi.airly.eu/v2/measurement/point?indexType=AIRLY_CAQI&lat=50.062006&lng=19.940984"),
                eq(GET),
                any(HttpEntity.class),
                eq(MeasurementPointResponse.class)))
                .thenReturn(new ResponseEntity<>(measurementPointResponse, HttpStatus.OK));

        Mockito.when(dtoParser.toDto(any(MeasurementPointResponse.class))).thenReturn(MeasurementPointDto.builder().build());

        MeasurementPointRequest request = MeasurementPointRequest.builder()
                .indexType("AIRLY_CAQ")
                .lat(50.062006)
                .lng(19.940984)
                .build();
        MeasurementPointDto resultExpected = MeasurementPointDto.builder().build();
        MeasurementPointDto result = testBean.getMeasurementPoint(request);

        Assert.assertEquals(resultExpected, result);
    }
}