package com.agnieszka.piotrowska.weatherCheckApp.service.measurement;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementPointDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementPointRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.MeasurementPointResponse;
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
@WebMvcTest(MeasurementPointService.class)
class MeasurementPointServiceTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    RestTemplate restTemplate;

    private MeasurementService testBean;
    @Autowired
    public void init(){
        testBean = new MeasurementService(null,
                null,new MeasurementPointService(restTemplate));
    }

    @Test
    void shouldReturnMeasurementPointURL() {
        MeasurementPointResponse measurementPointResponse = new MeasurementPointResponse();

        Mockito.when(restTemplate.exchange(
                "https://airapi.airly.eu/v2/measurement/point?indexType=AIRLY_CAQI&lat=50.062006&lng=19.940984",
                GET,
                new HttpEntity<>(new HttpHeaders()),
                MeasurementPointResponse.class))
                .thenReturn(new ResponseEntity<>(measurementPointResponse, HttpStatus.OK));

        MeasurementPointRequest request = MeasurementPointRequest.builder()
                .indexType("AIRLY_CAQ")
                .lat(50.062006)
                .lng(19.940984)
                .build();
        MeasurementPointDto resultExpected = new MeasurementPointDto();
        MeasurementPointDto result = testBean.getMeasurementPoint(request);

        Assert.assertEquals(resultExpected, result);
    }
}