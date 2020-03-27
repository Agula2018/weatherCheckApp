package com.agnieszka.piotrowska.weatherCheckApp.service;

import com.agnieszka.piotrowska.weatherCheckApp.util.URLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public abstract class AbstractExternalAPIService <T> {

    private static final String BASE_URL = "https://airapi.airly.eu/v2/";

    public RestTemplate restTemplate;

    @Autowired
    public AbstractExternalAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <RESPONSE> RESPONSE getFromRequest(T requestObject, Class<RESPONSE> responseClass){
        return get(getURLWithParams(requestObject), responseClass).getBody();
    }

    private <T> ResponseEntity <T> get(String url, Class<T> resultClass) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<T> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                resultClass);
    }

    protected String getBaseURL(){
        return BASE_URL + getDomainPath();
    }


    protected String getURLWithParams(T request){
        return getDomainPath() + buildURLParams(request);
    }

    protected abstract String getDomainPath();

    protected  String buildURLParams(T request) {
        return URLUtil.getURLParams(request);
    }

}
