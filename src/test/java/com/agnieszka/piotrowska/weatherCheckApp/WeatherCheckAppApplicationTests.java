package com.agnieszka.piotrowska.weatherCheckApp;

import com.agnieszka.piotrowska.weatherCheckApp.controller.InstallationsController;
import com.agnieszka.piotrowska.weatherCheckApp.controller.MeasurementsController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest
class WeatherCheckAppApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    InstallationsController installationsController;
    @MockBean
    MeasurementsController measurementsController;

    @Test
    void shouldReturnNearestInstallation() throws Exception {
        when(installationsController.handleNearestInstallation
                (50.062006, 19.940984, 3, 1)).thenReturn("ok");

        this.mockMvc.perform(MockMvcRequestBuilders.get("https://airapi.airly.eu/v2/installations/nearest")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }
    @Test
    void shouldReturnInstallationId() throws Exception {
        when(installationsController.handleInstallationId(8077))
              .thenReturn("ok");

        this.mockMvc.perform(MockMvcRequestBuilders.get("https://airapi.airly.eu/v2/installations/")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }
    @Test
    void shouldReturnDetailedMeasurement() throws Exception{
        when(measurementsController.detailedMeasurement("AIRLY_CAQI",204)).thenReturn("ok");
        this.mockMvc.perform(MockMvcRequestBuilders.get("https://airapi.airly.eu/v2/measurements/installation")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }
    @Test
    void shouldReturnDetailedMeasurementNearest() throws Exception{
        when(measurementsController.detailedMeasurementNearest
                ("AIRLY_CAQI",50.062006, 19.940984, 3)).thenReturn("ok");
        this.mockMvc.perform(MockMvcRequestBuilders.get("https://airapi.airly.eu/v2/measurements/installation/nearest/")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }
    @Test
    void shouldReturnDetailedMeasurementPoint() throws Exception{
        when(measurementsController.detailedMeasurementPoint
                ("AIRLY_CAQI",50.062006, 19.940984)).thenReturn("ok");
        this.mockMvc.perform(MockMvcRequestBuilders.get("https://airapi.airly.eu/v2/measurements/installation/point/")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }
}

