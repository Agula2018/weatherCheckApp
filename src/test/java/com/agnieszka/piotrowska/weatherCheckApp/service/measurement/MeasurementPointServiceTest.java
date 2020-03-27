package com.agnieszka.piotrowska.weatherCheckApp.service.measurement;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementPointDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@WebMvcTest(MeasurementPointService.class)
class MeasurementPointServiceTest {

    @Mock
    RestTemplate restTemplate;

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldReturnMeasurementPointURL() {
        MeasurementPointDto measurementPointDto = new MeasurementPointDto();

        Mockito.when(restTemplate.getForEntity(
                "https://airapi.airly.eu/v2/measurement/point" +
                        buildSuccessMeasuremntPointPath(),
                MeasurementPointDto.class))
                .thenReturn(new ResponseEntity<>(measurementPointDto, HttpStatus.OK));
    }

    private String buildSuccessMeasuremntPointPath() {
        return "?indexType=AIRLY_CAQI&lat=50.062006&lng=19.940984";
    }
}