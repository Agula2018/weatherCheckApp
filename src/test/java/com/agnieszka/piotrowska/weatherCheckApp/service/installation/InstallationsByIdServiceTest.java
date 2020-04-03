package com.agnieszka.piotrowska.weatherCheckApp.service.installation;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.InstallationsByIdDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.InstallationsByIdRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.InstallationByIdResponse;
import com.agnieszka.piotrowska.weatherCheckApp.parser.InstallationByIdParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.http.HttpMethod.GET;

@RunWith(SpringRunner.class)
@WebMvcTest(InstallationsByIdService.class)
public class InstallationsByIdServiceTest {

    @Mock
    RestTemplate restTemplate;

    @MockBean
    @Qualifier("installationByIdParser")
    private InstallationByIdParser dtoParser;

    private InstallationsService testBean;

    @Before
    public void init() {
        testBean = new InstallationsService(null, new InstallationsByIdService(restTemplate, dtoParser));
    }

    @Test
    public void shouldReturnInstallationByIdURL() {
        InstallationByIdResponse installationByIdResponse = new InstallationByIdResponse();

        Mockito.when(restTemplate.exchange(eq("https://airapi.airly.eu/v2/installations/8077"),
                eq(GET),
                any(HttpEntity.class),
                eq(InstallationByIdResponse.class)))
                .thenReturn(new ResponseEntity<>(installationByIdResponse, HttpStatus.OK));
        Mockito.when(dtoParser.toDto(any(InstallationByIdResponse.class))).thenReturn(InstallationsByIdDto.builder().build());

        InstallationsByIdRequest request = InstallationsByIdRequest.builder().installationId(8077).build();

        InstallationsByIdDto resultExpected = InstallationsByIdDto.builder().build();
        InstallationsByIdDto result = testBean.getInstallationsByIdDto(request);

        Assert.assertEquals(resultExpected, result);

    }

    @Test
    public void shouldReturnNotFoundInstallationException() {
        InstallationByIdResponse installationByIdResponse = new InstallationByIdResponse();

        Mockito.when(restTemplate.exchange("https://airapi.airly.eu/v2/installations/204",
                GET,
                new HttpEntity<>(new HttpHeaders()),
                InstallationByIdResponse.class))
                .thenReturn(new ResponseEntity<>(installationByIdResponse, HttpStatus.NOT_FOUND));

        InstallationsByIdRequest request = InstallationsByIdRequest.builder().installationId(204).build();

        InstallationsByIdDto resultExpected = InstallationsByIdDto.builder().build();
        InstallationsByIdDto result = testBean.getInstallationsByIdDto(request);

        Assert.assertEquals(resultExpected, result);

    }

    @Test
    public void shouldRedirectInstallationById() {
        InstallationByIdResponse installationByIdResponse = new InstallationByIdResponse();

        Mockito.when(restTemplate.exchange("https://airapi.airly.eu/v2/installations/204",
                GET,
                new HttpEntity<>(new HttpHeaders()),
                InstallationByIdResponse.class))
                .thenReturn(new ResponseEntity<>(installationByIdResponse, HttpStatus.MOVED_PERMANENTLY));

        InstallationsByIdRequest request = InstallationsByIdRequest.builder().installationId(204).build();

        InstallationsByIdDto resultExpected = InstallationsByIdDto.builder().build();
        InstallationsByIdDto result = testBean.getInstallationsByIdDto(request);

        Assert.assertEquals(resultExpected, result);
    }
}