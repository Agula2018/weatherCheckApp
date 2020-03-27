package com.agnieszka.piotrowska.weatherCheckApp.service.installation;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.InstallationsByIdDto;
import org.junit.Test;
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
public class InstallationsByIdServiceTest {

    @Mock
    RestTemplate restTemplate;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldReturnInstallationByIdURL(){
        InstallationsByIdDto installationsByIdDto = new InstallationsByIdDto();

        Mockito.when(restTemplate.getForEntity(
                "https://airapi.airly.eu/v2/installations/" +
                        buildSuccessfulInstallationByIdPath(),
                InstallationsByIdDto.class))
                .thenReturn(new ResponseEntity<>(installationsByIdDto, HttpStatus.OK));
    }
    private String buildSuccessfulInstallationByIdPath() {
        return "8077";
    }
}

