package com.agnieszka.piotrowska.weatherCheckApp.controller;

import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementForInstallationRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementNearestRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementPointRequest;
import com.agnieszka.piotrowska.weatherCheckApp.service.AirlyParsing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v2/measurements/")
public class MeasurementsController {

    private final AirlyParsing airlyParsing;

    @Autowired
    public MeasurementsController(AirlyParsing airlyParsing) {
        this.airlyParsing = airlyParsing;
    }


    @GetMapping("installation")
    public String measurementsForInstallation(@RequestParam("indexType") String indexType,
                                              @RequestParam("installationId") int installationId) throws JsonParseException {
        MeasurementForInstallationRequest request = MeasurementForInstallationRequest.builder()
                .indexType(indexType)
                .installationId(installationId)
                .build();

        return "ok";
    }

    @GetMapping("nearest")
    public String detailedMeasurementNearest(@RequestParam("indexType") String indexType,
                                             @RequestParam("lat") double lat,
                                             @RequestParam("lng") double lng,
                                             @RequestParam("maxDistanceKM") int maxDistanceKM) throws JsonParseException {
        MeasurementNearestRequest request = MeasurementNearestRequest.builder()
                .indexType(indexType)
                .lat(lat)
                .lng(lng)
                .maxDistanceKM(maxDistanceKM)
                .build();
        return "ok";
    }

    @GetMapping("point")
    public String detailedMeasurementPoint(@RequestParam("indexType") String indexType,
                                           @RequestParam("lat") double lat,
                                           @RequestParam("lng") double lng) throws JsonParseException {
        MeasurementPointRequest request = MeasurementPointRequest.builder()
                .indexType(indexType)
                .lat(lat)
                .lng(lng)
                .build();
        return "ok";
    }
}

