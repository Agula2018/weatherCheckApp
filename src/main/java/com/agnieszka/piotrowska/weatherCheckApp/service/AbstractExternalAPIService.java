package com.agnieszka.piotrowska.weatherCheckApp.service;

import com.agnieszka.piotrowska.weatherCheckApp.model.request.RequestForExternalAPI;
import com.agnieszka.piotrowska.weatherCheckApp.util.URLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
public abstract class AbstractExternalAPIService<T> {

    private static final String BASE_URL = "https://airapi.airly.eu/v2/";
    private static final String API_KEY_HEADER_NAME = "apikey";

    public RestTemplate restTemplate;

    @Value("${apikey}")
    private String apiKey;

    @Autowired
    public AbstractExternalAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <RESPONSE> RESPONSE getFromRequest(RequestForExternalAPI<T, RESPONSE> request) {
        ResponseEntity<RESPONSE> response = get(getURLWithParams(
                request.getRequestObject(),
                request.isQueryParam()),
                request.getResponseClass());
        try {
            return response.getBody();
        } catch (ResponseStatusException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "installation not found", ex);
        } catch (Exception e) {
            throw new ResponseStatusException
                    (HttpStatus.MOVED_PERMANENTLY, "follow redirect", e);
        }
    }

    private <T> ResponseEntity<T> get(String queryPart, Class<T> resultClass) {
        HttpEntity<T> entity = new HttpEntity<>(createHeaders());
        return restTemplate.exchange(
                getBaseURL() + queryPart,
                HttpMethod.GET,
                entity,
                resultClass);
    }

    private HttpHeaders createHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.add(API_KEY_HEADER_NAME, apiKey);
        return headers;
    }

    protected String getBaseURL() {
        return BASE_URL + getDomainPath();
    }

    protected String getURLWithParams(T request, boolean isQueryParam) {
        return buildURLParams(request, isQueryParam);
    }

    protected abstract String getDomainPath();

    protected String buildURLParams(T request, boolean isQueryParam) {
        return URLUtil.getURLParams(request, isQueryParam);
    }
}
