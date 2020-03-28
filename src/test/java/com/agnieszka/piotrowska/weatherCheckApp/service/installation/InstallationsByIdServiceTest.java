package com.agnieszka.piotrowska.weatherCheckApp.service.installation;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.InstallationsByIdDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.InstallationsByIdRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.InstallationByIdResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.*;
import static org.springframework.http.HttpMethod.GET;

@RunWith(SpringRunner.class)
@WebMvcTest(InstallationsByIdService.class)
public class InstallationsByIdServiceTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    RestTemplate restTemplate;

    private InstallationsService testBean;

    @Before
    public void init() {
        testBean = new InstallationsService(null, new InstallationsByIdService(restTemplate));
    }

    @Test
    public void shouldReturnInstallationByIdURL(){
        InstallationByIdResponse installationByIdResponse = new InstallationByIdResponse();
        
        Mockito.when(restTemplate.exchange("https://airapi.airly.eu/v2/installations/8077",
                GET,
                new HttpEntity<>(new HttpHeaders()),
                InstallationByIdResponse.class))
                .thenReturn(new ResponseEntity<>(installationByIdResponse, HttpStatus.OK));

        InstallationsByIdRequest request = InstallationsByIdRequest.builder().installationId(8077).build();

        InstallationsByIdDto resultExpected = new InstallationsByIdDto();
        InstallationsByIdDto result = testBean.getInstallationsByIdDto(request);

        Assert.assertEquals(resultExpected, result);

    }

}

