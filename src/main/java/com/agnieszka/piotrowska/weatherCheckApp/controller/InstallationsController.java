package com.agnieszka.piotrowska.weatherCheckApp.controller;

import com.agnieszka.piotrowska.weatherCheckApp.model.request.InstallationsByIdRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.NearestInstallationRequest;
import com.agnieszka.piotrowska.weatherCheckApp.service.AirlyParsing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.*;

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
                                            @RequestParam("maxDistanceKM") int maxDistanceKM,
                                            @RequestParam("maxResults") int maxResults) throws JsonParseException {
        NearestInstallationRequest req = NearestInstallationRequest.builder()
                .lat(lat)
                .lng(lng)
                .maxDistanceKm(maxDistanceKM)
                .maxResults(maxResults)
                .build();

        return ("ok");
    }

    @GetMapping("{installationId}")
    public String handleInstallationId(@PathVariable("installationId") int installationId) throws JsonParseException {

        InstallationsByIdRequest request = InstallationsByIdRequest.builder()
                .installationId(installationId)
                .build();

        return "ok";
    }
}