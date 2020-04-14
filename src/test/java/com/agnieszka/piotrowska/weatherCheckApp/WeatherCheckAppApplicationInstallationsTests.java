package com.agnieszka.piotrowska.weatherCheckApp;

import com.agnieszka.piotrowska.weatherCheckApp.controller.InstallationsController;
import com.agnieszka.piotrowska.weatherCheckApp.model.dto.InstallationsByIdDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.dto.NearestInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.InstallationsByIdRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.NearestInstallationRequest;
import com.agnieszka.piotrowska.weatherCheckApp.service.installation.InstallationsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InstallationsController.class)

public class WeatherCheckAppApplicationInstallationsTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private InstallationsService installationsService;

    @Test
    public void shouldReturnNearestInstallation() throws Exception {

        Mockito.when(installationsService.getNearestInstallation(
                NearestInstallationRequest.builder()
                        .lat(50.062006)
                        .lng(19.940984)
                        .maxDistanceKM(3)
                        .maxResults(1)
                        .build()
        )).thenReturn(List.of(NearestInstallationDto.builder().build()));

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get
                ("http://localhost:8080/v2/installations/nearest" + buildSuccessfulNearestPath())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        String json = mvcResult.getResponse().getContentAsString();
        String jsonExpected = objectMapper.writeValueAsString(List.of(NearestInstallationDto.builder().build()));
//        NearestInstallationResponse responseObject = objectMapper.readValue(json, NearestInstallationResponse.class);

        assertEquals(jsonExpected, json);
    }

    private String buildSuccessfulNearestPath() {
        return "?lat=50.062006&lng=19.940984&maxDistanceKM=3&maxResults=1";
    }

    @Test
    public void shouldReturnInstallationId() throws Exception {
        Mockito.when(installationsService.getInstallationsByIdDto
                (InstallationsByIdRequest.builder()
                        .installationId(8077)
                        .build()))
                .thenReturn(InstallationsByIdDto.builder().build());

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get
                ("http://localhost:8080/v2/installations/" + buildSuccessfulInstallationId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        String json = mvcResult.getResponse().getContentAsString();
        String jsonExpected = objectMapper.writeValueAsString(InstallationsByIdDto.builder().build());

        assertEquals(jsonExpected, json);
    }
    private String buildSuccessfulInstallationId() {
        return "8077";
    }
}


