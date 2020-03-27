package com.agnieszka.piotrowska.weatherCheckApp.service.measurement;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementNearestDto;
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
@WebMvcTest(MeasurementNearestService.class)
class MeasurementNearestServiceTest {

    @Mock
    RestTemplate restTemplate;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldReturnMeasurementNearestURL(){

        MeasurementNearestDto measurementNearestDto = new MeasurementNearestDto();
        Mockito.when(restTemplate.getForEntity(
                "https://airapi.airly.eu/v2/measurement/nearest" +
                        buildSuccessfulMeasurementNearestPath(),
                MeasurementNearestDto.class))
                .thenReturn(new ResponseEntity<>(measurementNearestDto, HttpStatus.OK));
    }

    private String buildSuccessfulMeasurementNearestPath() {
        return "?indexType=AIRLY_CAQI&lat=50.062006&lng=19.940984&maxDistanceKM=3";
    }
}
