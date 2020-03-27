package com.agnieszka.piotrowska.weatherCheckApp.service.measurement;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementForInstallationDto;
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
@WebMvcTest(MeasurementForInstallationService.class)
class MeasurementForInstallationServiceTest {

    @Mock
    RestTemplate restTemplate;

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldReturnMeasurementsForInstallationURL() {
        MeasurementForInstallationDto measurementForInstallationDto = new MeasurementForInstallationDto();

        Mockito.when(restTemplate.getForEntity(
                "https://airapi.airly.eu/v2/measurement/installation" +
                        buildSuccessMeasurementInstallationPath(),
                MeasurementForInstallationDto.class))
                .thenReturn(new ResponseEntity<>(measurementForInstallationDto, HttpStatus.OK));
    }

    private String buildSuccessMeasurementInstallationPath() {
        return "?indexType=AIRLY_CAQI&installationId=204";
    }
}