package com.agnieszka.piotrowska.weatherCheckApp.service.installation;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.NearestInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.NearestInstallationRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.NearestInstallationResponse;
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
@WebMvcTest(NearestInstallationService.class)
class NearestInstallationServiceTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    RestTemplate restTemplate;

    private InstallationsService testBean;
    @Autowired
    public void init(){
        testBean = new InstallationsService(new NearestInstallationService(restTemplate),null);
    }

    @Test
    public void shouldReturnNearestInstallationURL() {
        NearestInstallationResponse nearestInstallationResponse = new NearestInstallationResponse();

        Mockito.when(restTemplate.exchange(
                "https://airapi.airly.eu/v2/installations/nearest?lat=50.062006&lng=19.940984&maxDistanceKM=3&maxResults=1",
                GET,
                new HttpEntity<>(new HttpHeaders()),
                NearestInstallationResponse.class))
                .thenReturn(new ResponseEntity<>(nearestInstallationResponse, HttpStatus.OK));

        NearestInstallationRequest request = NearestInstallationRequest.builder()
                .lat(50.062006).lng(19.940984).maxDistanceKm(3).maxResults(1).build();

        NearestInstallationDto resultExpected = new NearestInstallationDto();
        NearestInstallationDto result = testBean.getNearestInstallation(request);

        Assert.assertEquals(resultExpected, result);

    }
}
