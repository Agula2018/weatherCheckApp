package com.agnieszka.piotrowska.weatherCheckApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainController {


    public final String BASE_URL = "https://airapi.airly.eu/";

    @Autowired
    private RestTemplate restTemplate;


}
