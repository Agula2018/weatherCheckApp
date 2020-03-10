package com.agnieszka.piotrowska.weatherCheckApp.controller;

import com.agnieszka.piotrowska.weatherCheckApp.service.ParsingService;
import com.google.gson.JsonParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v2/measurements/")
public class MeasurementsController {

    private final ParsingService parsingService;

    @Autowired
    public MeasurementsController(ParsingService parsingService) {
        this.parsingService = parsingService;
    }


    @GetMapping("installation")
    public String detailedMeasurement(@RequestParam("indexType") String indexType,
                                      @RequestParam("installationId") int installationId) throws JsonParseException {
        return "ok";
    }

    @GetMapping("nearest")
    public String detailedMeasurementNearest(@RequestParam("indexType") String indexType,
                                             @RequestParam("lat") double lat,
                                             @RequestParam("lng") double lng,
                                             @RequestParam("maxDistanceKM") double maxDistanceKM) throws JsonParseException {
        return "ok";
    }

    @GetMapping("point")
    public String detailedMeasurementPoint(@RequestParam("indexType") String indexType,
                                           @RequestParam("lat") double lat,
                                           @RequestParam("lng") double lng) throws JsonParseException {
        return "ok";
    }
}

