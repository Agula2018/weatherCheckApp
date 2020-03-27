package com.agnieszka.piotrowska.weatherCheckApp.service;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.*;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.*;
import com.agnieszka.piotrowska.weatherCheckApp.service.installation.InstallationsService;
import com.agnieszka.piotrowska.weatherCheckApp.service.measurement.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlyService {

    private InstallationsService installationsService;
    private MeasurementService measurementService;

    @Autowired
    public AirlyService(InstallationsService installationsService, MeasurementService measurementService) {
        this.installationsService = installationsService;
        this.measurementService = measurementService;
    }

    public NearestInstallationDto getNearestInstallations (NearestInstallationRequest request){
       NearestInstallationRequest.builder()
               .lat(50.062006)
               .lng(19.940984)
               .maxDistanceKm(3)
               .maxResults(1)
               .build();
        return new NearestInstallationDto();
    }

    public InstallationsByIdDto getInstallationById(InstallationsByIdRequest request){
        InstallationsByIdRequest.builder()
                .installationId(8077)
                .build();
        return new InstallationsByIdDto();
    }

    public MeasurementForInstallationDto getMeasurementForInstallation(MeasurementForInstallationRequest request){
        MeasurementForInstallationRequest.builder()
                .indexType("AIRLY_CAQI")
                .installationId(8077)
                .build();
        return new MeasurementForInstallationDto();
    }

    public MeasurementNearestDto getMeasurementNearest(MeasurementNearestRequest request){
        MeasurementNearestRequest.builder()
                .indexType("AIRLY_CAQI")
                .lat(50.062006)
                .lng(19.940984)
                .maxDistanceKM(3)
                .build();
        return new MeasurementNearestDto();
    }
    public MeasurementPointDto getMeasurementPoint(MeasurementPointRequest request){
        MeasurementPointRequest.builder()
                .indexType("AIRLY_CAQI")
                .lat(50.062006)
                .lng(19.940984)
                .build();
        return new MeasurementPointDto();
    }
}