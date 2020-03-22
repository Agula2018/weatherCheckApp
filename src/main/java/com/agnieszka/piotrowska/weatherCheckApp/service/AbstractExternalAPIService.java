package com.agnieszka.piotrowska.weatherCheckApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AbstractExternalAPIService<T> {

    public RestTemplate restTemplate;

    @Autowired
    public AbstractExternalAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /*
    Spring's UriComponentsBuilder class is for easily manipulate URLs / path / params / etc.
    It's manually concatenating strings and it takes care of the URL encoding
     */

    public ResponseEntity<T> get(String url, Class<T> resultClass) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<T> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                resultClass);
    }
}
