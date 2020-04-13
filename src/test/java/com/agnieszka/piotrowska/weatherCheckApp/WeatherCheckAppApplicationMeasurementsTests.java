package com.agnieszka.piotrowska.weatherCheckApp;

import com.agnieszka.piotrowska.weatherCheckApp.controller.MeasurementsController;
import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementForInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementNearestDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementPointDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementForInstallationRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementNearestRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementPointRequest;
import com.agnieszka.piotrowska.weatherCheckApp.service.measurement.MeasurementService;
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

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MeasurementsController.class)
public class WeatherCheckAppApplicationMeasurementsTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private MeasurementService measurementService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldReturnDetailedMeasurement() throws Exception {

        Mockito.when(measurementService.getMeasurementForInstallation(
                MeasurementForInstallationRequest.builder()
                        .indexType("AIRLY_CAQI")
                        .installationId(8077)
                        .build()))
                .thenReturn(MeasurementForInstallationDto.builder().build());


        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get
                ("http://localhost:8080/v2/measurements/installation/" +
                        buildSuccessfulDetailedMeasurement())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        assertEquals(MeasurementForInstallationDto.builder().build().toString(), mvcResult.getResponse().getContentAsString());
    }

    private String buildSuccessfulDetailedMeasurement() {
        return "?indexType=AIRLY_CAQI&installationId=8077";
    }

    @Test
    public void shouldReturnNearestMeasurement() throws Exception {
        Mockito.when(measurementService.getMeasurementNearest(
                MeasurementNearestRequest.builder()
                        .indexType("AIRLY_CAQI")
                        .lat(50.062006)
                        .lng(19.940984)
                        .maxDistanceKM(3)
                        .build()))
                .thenReturn(MeasurementNearestDto.builder().build());

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get
                ("http://localhost:8080/v2/measurements/nearest" +
                        buildSuccessfulNearestMeasurementPath())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        assertEquals(MeasurementNearestDto.builder().build(), mvcResult.getResponse().getContentAsString());
    }

    private String buildSuccessfulNearestMeasurementPath() {
        return "?indexType=AIRLY_CAQI&lat=50.062006&lng=19.940984&maxDistanceKM=3";
    }

    @Test
    public void shouldReturnMeasurementPoint() throws Exception {

        Mockito.when(measurementService.getMeasurementPoint(
                MeasurementPointRequest.builder()
                .indexType("AIRLY_CAQI")
                .lat(50.062006)
                .lng(19.940984)
                .build()))
                .thenReturn(MeasurementPointDto.builder().build());

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/v2/measurements/point" +
                buildSuccessfulMeasurementPoint())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        assertEquals(MeasurementPointDto.builder().build().toString(), mvcResult.getResponse().getContentAsString());
    }

    private String buildSuccessfulMeasurementPoint() {
        return "?indexType=AIRLY_CAQI&lat=50.062006&lng=19.940984";
    }
}
