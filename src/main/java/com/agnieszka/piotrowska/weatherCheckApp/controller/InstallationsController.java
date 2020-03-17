package com.agnieszka.piotrowska.weatherCheckApp.controller;

import com.agnieszka.piotrowska.weatherCheckApp.model.Installations;
import com.agnieszka.piotrowska.weatherCheckApp.service.AirlyParsing;
import com.google.gson.JsonParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("v2/installations/")
public class InstallationsController {

    private final AirlyParsing airlyParsing;

    @Autowired
    public InstallationsController(AirlyParsing airlyParsing) {
        this.airlyParsing = airlyParsing;
    }

    public RestTemplate restTemplate;

    @Autowired
    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    @GetMapping("nearest/")
    public String handleNearestInstallation(@RequestParam("lat") double lat,
                                            @RequestParam("lng") double lng,
                                            @RequestParam("maxDistanceKM") double maxDistanceKM,
                                            @RequestParam("maxResults") int maxResults) throws JsonParseException {
        restTemplate.getForObject("https://airapi.airly.eu/v2/installations/nearest"
                + lat + lng + maxDistanceKM + maxResults, Installations.class);

        return ("ok");
    }

    @GetMapping("{installationId}/")
    public String handleInstallationId(@PathVariable("installationId") int installationId) throws JsonParseException {
        restTemplate.getForObject("https://airapi.airly.eu/v2/installations/" + installationId, Installations.class);
        return "ok";
    }
}