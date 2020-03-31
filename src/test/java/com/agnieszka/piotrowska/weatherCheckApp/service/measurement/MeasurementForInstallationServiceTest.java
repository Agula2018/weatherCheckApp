package com.agnieszka.piotrowska.weatherCheckApp.service.measurement;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementForInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementForInstallationRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.MeasurementForInstallationResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import static org.springframework.http.HttpMethod.GET;

@RunWith(SpringRunner.class)
@WebMvcTest(MeasurementForInstallationService.class)
class MeasurementForInstallationServiceTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    RestTemplate restTemplate;

    private MeasurementService testBean;

    @Autowired
    public void init(){
        testBean = new MeasurementService(new MeasurementForInstallationService(restTemplate),
                null,  null);
    }

    @Test
    public void shouldReturnMeasurementsForInstallationURL() {
        MeasurementForInstallationResponse measurementForInstallationResponse = new MeasurementForInstallationResponse();

        Mockito.when(restTemplate.exchange(
                "https://airapi.airly.eu/v2/measurement/installation?indexType=AIRLY_CAQI&installationId=8077",
                GET,
                new HttpEntity <>(new HttpHeaders()),
                MeasurementForInstallationResponse.class))
                .thenReturn(new ResponseEntity<>(measurementForInstallationResponse, HttpStatus.OK));

        MeasurementForInstallationRequest request = MeasurementForInstallationRequest.builder()
                .indexType("AIRLY_CAQI")
                .installationId(8077)
                .build();

        MeasurementForInstallationDto resultExpected = new MeasurementForInstallationDto();
        MeasurementForInstallationDto result = testBean.getMeasurementForInstallation(request);

        Assert.assertEquals(resultExpected, result);
    }
    @Test
    public void shouldReturnNotFoundMeasurementsForInstallationURL() {
        MeasurementForInstallationResponse measurementForInstallationResponse = new MeasurementForInstallationResponse();

        Mockito.when(restTemplate.exchange(
                "https://airapi.airly.eu/v2/measurement/installation?indexType=AIRLY_CAQI&installationId=8020",
                GET,
                new HttpEntity <>(new HttpHeaders()),
                MeasurementForInstallationResponse.class))
                .thenReturn(new ResponseEntity<>(measurementForInstallationResponse, HttpStatus.NOT_FOUND));

        MeasurementForInstallationRequest request = MeasurementForInstallationRequest.builder()
                .indexType("AIRLY_CAQI")
                .installationId(8020)
                .build();

        MeasurementForInstallationDto resultExpected = new MeasurementForInstallationDto();
        MeasurementForInstallationDto result = testBean.getMeasurementForInstallation(request);

        Assert.assertEquals(resultExpected, result);
    }
    @Test
    public void shouldRedirectMeasurementsForInstallation() {
        MeasurementForInstallationResponse measurementForInstallationResponse = new MeasurementForInstallationResponse();

        Mockito.when(restTemplate.exchange(
                "https://airapi.airly.eu/v2/measurement/installation?indexType=AIRLY_CAQI&installationId=204",
                GET,
                new HttpEntity <>(new HttpHeaders()),
                MeasurementForInstallationResponse.class))
                .thenReturn(new ResponseEntity<>(measurementForInstallationResponse, HttpStatus.MOVED_PERMANENTLY));

        MeasurementForInstallationRequest request = MeasurementForInstallationRequest.builder()
                .indexType("AIRLY_CAQI")
                .installationId(204)
                .build();

        MeasurementForInstallationDto resultExpected = new MeasurementForInstallationDto();
        MeasurementForInstallationDto result = testBean.getMeasurementForInstallation(request);

        Assert.assertEquals(resultExpected, result);
    }
}