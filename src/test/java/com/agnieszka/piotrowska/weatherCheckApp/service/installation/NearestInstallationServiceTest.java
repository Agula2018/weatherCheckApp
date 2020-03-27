package com.agnieszka.piotrowska.weatherCheckApp.service.installation;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.NearestInstallationDto;
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
@WebMvcTest(InstallationsByIdService.class)
class NearestInstallationServiceTest {

    @Mock
    RestTemplate restTemplate;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldReturnNearestInstallationURL() {

        NearestInstallationDto nearestInstallationDto = new NearestInstallationDto();
        Mockito.when(restTemplate.getForEntity(
                "https://airapi.airly.eu/v2/installations/nearest" + buildSuccessfulNearestInstallationPath(),
                NearestInstallationDto.class))
                .thenReturn(new ResponseEntity<>(nearestInstallationDto, HttpStatus.OK));

    }

    private String buildSuccessfulNearestInstallationPath() {
        return "?lat=50.062006&lng=19.940984&maxDistanceKM=3&maxResults=1";
    }
}
