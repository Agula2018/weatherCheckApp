package com.agnieszka.piotrowska.weatherCheckApp.controller;

import com.agnieszka.piotrowska.weatherCheckApp.model.Installations;
import com.agnieszka.piotrowska.weatherCheckApp.service.AirlyParsing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
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

    @GetMapping("nearest")
    public String handleNearestInstallation(@RequestParam("lat") double lat,
                                            @RequestParam("lng") double lng,
                                            @RequestParam("maxDistanceKM") double maxDistanceKM,
                                            @RequestParam("maxResults") int maxResults) throws JsonParseException {
        /* mock */airlyParsing.parse("");
        return ("ok");
    }

    @GetMapping("{installationId}")
    public String handleInstallationId(@PathVariable("installationId") int installationId) throws JsonParseException {
        return "ok";
    }
}