package com.agnieszka.piotrowska.weatherCheckApp.controller;

import com.agnieszka.piotrowska.weatherCheckApp.service.ParsingService;
import com.google.gson.JsonParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("airapi.airly.eu/v2/")
public class AirlyController {

    private final ParsingService parsingService;

    @Autowired
    public AirlyController(ParsingService parsingService) {
        this.parsingService = parsingService;
    }


    @GetMapping("installations/nearest/")
    public String handleNearestInstallation(@RequestParam("lat") double lat,
                                            @RequestParam("lng") double lng,
                                            @RequestParam("maxDistanceKM") double maxDistanceKM,
                                            @RequestParam("maxResults") int maxResults) throws JsonParseException {
        return "ok";
    }

    @GetMapping("installations/{installationId}")
    public String handleInstallationId(@PathVariable("installationId") int installationId) throws JsonParseException {
        return "ok";
    }

    @GetMapping("measurements/installation")
    public String detailedMeasurement(@RequestParam("indexType") String indexType,
                                      @RequestParam("installationId") int installationId) throws JsonParseException {
        return "ok";
    }

    @GetMapping("measurements/nearest")
    public String detailedMeasurementNearest(@RequestParam("indexType") String indexType,
                                             @RequestParam("lat") double lat,
                                             @RequestParam("lng") double lng,
                                             @RequestParam("maxDistanceKM") double maxDistanceKM) throws JsonParseException {
        return "ok";
    }

    @GetMapping("measurements/point")
    public String detailedMeasurementPoint(@RequestParam("indexType") String indexType,
                                           @RequestParam("lat") double lat,
                                           @RequestParam("lng") double lng) throws JsonParseException {
        return "ok";
    }
}

