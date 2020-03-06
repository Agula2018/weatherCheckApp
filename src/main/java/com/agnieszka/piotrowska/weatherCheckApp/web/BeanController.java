package com.agnieszka.piotrowska.weatherCheckApp.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanController {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}