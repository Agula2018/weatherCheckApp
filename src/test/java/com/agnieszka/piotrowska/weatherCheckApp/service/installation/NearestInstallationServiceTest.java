package com.agnieszka.piotrowska.weatherCheckApp.service.installation;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.NearestInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.NearestInstallationRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.NearestInstallationResponse;
import com.agnieszka.piotrowska.weatherCheckApp.parser.NearestInstallationParser;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.http.HttpMethod.GET;

@RunWith(SpringRunner.class)
@WebMvcTest(NearestInstallationService.class)
class NearestInstallationServiceTest {

    @Mock
    RestTemplate restTemplate;

    @MockBean
    @Qualifier("nearestInstallationParser")
    private NearestInstallationParser dtoParser;

    private InstallationsService testBean;

    @Autowired
    public void init(){
        testBean = new InstallationsService(new NearestInstallationService(restTemplate, dtoParser),null);
    }

    @Test
    public void shouldReturnNearestInstallationURL() {
        NearestInstallationResponse nearestInstallationResponse = new NearestInstallationResponse();

        Mockito.when(restTemplate.exchange
                (eq("https://airapi.airly.eu/v2/installations/nearest?lat=50.062006&lng=19.940984&maxDistanceKM=3&maxResults=1"),
                eq(GET),
                any(HttpEntity.class),
                eq(NearestInstallationResponse.class)))
                .thenReturn(new ResponseEntity<>(nearestInstallationResponse, HttpStatus.OK));

        Mockito.when(dtoParser.toDto(any(NearestInstallationResponse.class))).thenReturn((NearestInstallationDto.builder().build()));

        NearestInstallationRequest request = NearestInstallationRequest.builder()
                .lat(50.062006).lng(19.940984).maxDistanceKm(3).maxResults(1).build();

        NearestInstallationDto resultExpected = NearestInstallationDto.builder().build();
        NearestInstallationDto result = testBean.getNearestInstallation(request);

        Assert.assertEquals(resultExpected, result);

    }
}
