package com.agnieszka.piotrowska.weatherCheckApp.controller;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementForInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementNearestDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementPointDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementForInstallationRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementNearestRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementPointRequest;
import com.agnieszka.piotrowska.weatherCheckApp.service.measurement.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v2/measurements/")
public class MeasurementsController {

    private MeasurementService measurementService;

    @Autowired
    public MeasurementsController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }


    @GetMapping("installation")
    public MeasurementForInstallationDto measurementsForInstallation(@RequestParam("indexType") String indexType,
                                              @RequestParam("installationId") int installationId) throws JsonParseException {

        MeasurementForInstallationRequest request = MeasurementForInstallationRequest.builder()
                .indexType(indexType)
                .installationId(installationId)
                .build();

        MeasurementForInstallationDto dto = measurementService.getMeasurementForInstallation(request);

        return dto;
    }

    @GetMapping("nearest")
    public MeasurementNearestDto detailedMeasurementNearest(@RequestParam("indexType") String indexType,
                                             @RequestParam("lat") double lat,
                                             @RequestParam("lng") double lng,
                                             @RequestParam("maxDistanceKM") int maxDistanceKM) throws JsonParseException {
        MeasurementNearestRequest request = MeasurementNearestRequest.builder()
                .indexType(indexType)
                .lat(lat)
                .lng(lng)
                .maxDistanceKM(maxDistanceKM)
                .build();
        MeasurementNearestDto dto =measurementService.getMeasurementNearest(request);

        return dto;
    }

    @GetMapping("point")
    public MeasurementPointDto detailedMeasurementPoint(@RequestParam("indexType") String indexType,
                                           @RequestParam("lat") double lat,
                                           @RequestParam("lng") double lng) throws JsonParseException {
        MeasurementPointRequest request = MeasurementPointRequest.builder()
                .indexType(indexType)
                .lat(lat)
                .lng(lng)
                .build();

        MeasurementPointDto dto = measurementService.getMeasurementPoint(request);
        return dto;
    }
}

