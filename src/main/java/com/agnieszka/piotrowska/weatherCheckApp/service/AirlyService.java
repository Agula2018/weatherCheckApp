package com.agnieszka.piotrowska.weatherCheckApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AirlyService extends AirlyParsing {

    public RestTemplate restTemplate;

    @Autowired
    public RestTemplate getRestTemplate() {
        return restTemplate;
    }
    @Override
    public Object parse(String url) {
        return restTemplate.getForObject(url, Object.class);
    }
}