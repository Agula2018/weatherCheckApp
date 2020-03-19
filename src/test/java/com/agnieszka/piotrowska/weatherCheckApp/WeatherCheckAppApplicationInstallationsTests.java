package com.agnieszka.piotrowska.weatherCheckApp;

import com.agnieszka.piotrowska.weatherCheckApp.controller.InstallationsController;
import com.agnieszka.piotrowska.weatherCheckApp.service.AirlyParsing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InstallationsController.class)
public class WeatherCheckAppApplicationInstallationsTests {

    @MockBean
    AirlyParsing airlyParsing;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldReturnNearestInstallation() throws Exception {
        when(airlyParsing.parse(any(String.class))).thenReturn(null);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get
                ("http://localhost:8080/v2/installations/nearest" + buildSuccessfulNearestPath())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        assertEquals("ok", mvcResult.getResponse().getContentAsString());
    }

    private String buildSuccessfulNearestPath() {
        return "?lat=50.062006&lng=19.940984&maxDistanceKM=3&maxResults=1";
    }

    @Test
    public void shouldReturnInstallationId() throws Exception{
         when(airlyParsing.parse(any(String.class))).thenReturn(null);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get
                ("http://localhost:8080/v2/installations/" + buildSuccessfulInstallationId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        assertEquals("ok", mvcResult.getResponse().getContentAsString());
    }

    private String buildSuccessfulInstallationId() {
        return "8077";
    }
}


