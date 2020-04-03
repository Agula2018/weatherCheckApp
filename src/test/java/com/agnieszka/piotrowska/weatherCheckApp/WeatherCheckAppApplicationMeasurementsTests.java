package com.agnieszka.piotrowska.weatherCheckApp;

import com.agnieszka.piotrowska.weatherCheckApp.controller.MeasurementsController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MeasurementsController.class)
public class WeatherCheckAppApplicationMeasurementsTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldReturnDetailedMeasurement() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get
                ("http://localhost:8080/v2/measurements/installation/" +
                buildSuccessfulDetailedMeasurement())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        Assert.assertEquals("ok", mvcResult.getResponse().getContentAsString());
    }

    private String buildSuccessfulDetailedMeasurement() {
        return "?indexType=AIRLY_CAQI&installationId=8077";
    }

    @Test
    public void shouldReturnNearestMeasurement() throws Exception{
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get
                ("http://localhost:8080/v2/measurements/nearest" +
                        buildSuccessfulNearestMeasurementPath())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        Assert.assertEquals("ok",mvcResult.getResponse().getContentAsString());
    }

    private String buildSuccessfulNearestMeasurementPath() {
        return "?indexType=AIRLY_CAQI&lat=50.062006&lng=19.940984&maxDistanceKM=3";
    }

    @Test
    public void shouldReturnMeasurementPoint()throws Exception{
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/v2/measurements/point" +
                buildSuccessfulMeasurementPoint())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        Assert.assertEquals("ok", mvcResult.getResponse().getContentAsString());
    }

    private String buildSuccessfulMeasurementPoint() {
        return "?indexType=AIRLY_CAQI&lat=50.062006&lng=19.940984";
    }
}
