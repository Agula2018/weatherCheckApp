package com.agnieszka.piotrowska.weatherCheckApp.service.measurement;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementForInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementForInstallationRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.MeasurementForInstallationResponse;
import com.agnieszka.piotrowska.weatherCheckApp.parser.MeasurementForInstallationParser;
import com.agnieszka.piotrowska.weatherCheckApp.parser.Parser;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.GET;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@RunWith(SpringRunner.class)
@WebMvcTest(MeasurementForInstallationService.class)
class MeasurementForInstallationServiceTest {

    @Mock
    RestTemplate restTemplate;

    @MockBean
    @Qualifier("measurementForInstallationParser")
    private MeasurementForInstallationParser dtoParser;

    private MeasurementService testBean;

    @Autowired
    public void init() {
        testBean = new MeasurementService(new MeasurementForInstallationService(restTemplate, dtoParser),
                null, null);
    }

    @Test
    public void shouldReturnMeasurementsForInstallationURL() {
        MeasurementForInstallationResponse measurementForInstallationResponse = new MeasurementForInstallationResponse();

        Mockito.when(restTemplate.exchange(
                eq("https://airapi.airly.eu/v2/measurements/installation?indexType=AIRLY_CAQI&installationId=8077"),
                eq(GET),
                any(HttpEntity.class),
                eq(MeasurementForInstallationResponse.class)))
                .thenReturn(new ResponseEntity<>(measurementForInstallationResponse, HttpStatus.OK));

        MeasurementForInstallationRequest request = MeasurementForInstallationRequest.builder()
                .indexType("AIRLY_CAQI")
                .installationId(8077)
                .build();

        Mockito.when(dtoParser.toDto(any(MeasurementForInstallationResponse.class))).thenCallRealMethod();

        MeasurementForInstallationDto resultExpected = MeasurementForInstallationDto.builder().build();
        MeasurementForInstallationDto result = testBean.getMeasurementForInstallation(request);

        Assert.assertEquals(resultExpected, result);
    }

    @Test
    public void shouldReturnNotFoundMeasurementsForInstallationURL() {
        MeasurementForInstallationResponse measurementForInstallationResponse = new MeasurementForInstallationResponse();

        Mockito.when(restTemplate.exchange(
                eq("https://airapi.airly.eu/v2/measurements/installation?indexType=AIRLY_CAQI&installationId=8020"),
                eq(GET),
                any(HttpEntity.class),
                eq(MeasurementForInstallationResponse.class)))
                .thenReturn(new ResponseEntity<>(measurementForInstallationResponse, HttpStatus.NOT_FOUND));

        MeasurementForInstallationRequest request = MeasurementForInstallationRequest.builder()
                .indexType("AIRLY_CAQI")
                .installationId(8020)
                .build();

        Mockito.when(dtoParser.toDto(any(MeasurementForInstallationResponse.class))).thenCallRealMethod();

        MeasurementForInstallationDto resultExpected = MeasurementForInstallationDto.builder().build();
        MeasurementForInstallationDto result = testBean.getMeasurementForInstallation(request);

        Assert.assertEquals(resultExpected, result);
    }

    @Test
    public void shouldRedirectMeasurementsForInstallation() {
        MeasurementForInstallationResponse measurementForInstallationResponse = new MeasurementForInstallationResponse();

        Mockito.when(restTemplate.exchange(
                eq("https://airapi.airly.eu/v2/measurements/installation?indexType=AIRLY_CAQI&installationId=204"),
                eq(GET),
                any(HttpEntity.class),
                eq(MeasurementForInstallationResponse.class)))
                .thenReturn(new ResponseEntity<>(measurementForInstallationResponse, HttpStatus.MOVED_PERMANENTLY));

        MeasurementForInstallationRequest request = MeasurementForInstallationRequest.builder()
                .indexType("AIRLY_CAQI")
                .installationId(204)
                .build();

        Mockito.when(dtoParser.toDto(any(MeasurementForInstallationResponse.class))).thenCallRealMethod();

        MeasurementForInstallationDto resultExpected = MeasurementForInstallationDto.builder().build();
        MeasurementForInstallationDto result = testBean.getMeasurementForInstallation(request);

        Assert.assertEquals(resultExpected, result);
    }
}