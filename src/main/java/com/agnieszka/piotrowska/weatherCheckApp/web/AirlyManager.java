package com.agnieszka.piotrowska.weatherCheckApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirlyManager {

    private AirlyRetrofitClient airlyRetrofitClient;

    @Autowired
    public AirlyManager(AirlyRetrofitClient airlyRetrofitClient) {
        this.airlyRetrofitClient = airlyRetrofitClient;
    }
}
