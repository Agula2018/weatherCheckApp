package com.agnieszka.piotrowska.weatherCheckApp.service.measurement;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementForInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementNearestDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementPointDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementForInstallationRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementNearestRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementPointRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeasurementService{

    private MeasurementForInstallationService measurementForInstallationService;
    private MeasurementNearestService measurementNearestService;
    private MeasurementPointService measurementPointService;

    @Autowired
    public MeasurementService(MeasurementForInstallationService measurementForInstallationService,
                              MeasurementNearestService measurementNearestService,
                              MeasurementPointService measurementPointService) {
        this.measurementForInstallationService = measurementForInstallationService;
        this.measurementNearestService = measurementNearestService;
        this.measurementPointService = measurementPointService;
    }

    public MeasurementForInstallationDto getMeasurementForInstallation(MeasurementForInstallationRequest request){
        return getMeasurementForInstallation(request);
    }

    public MeasurementNearestDto getMeasurementNearest(MeasurementNearestRequest request){
        return getMeasurementNearest(request);
    }
    public MeasurementPointDto getMeasurementPoint(MeasurementPointRequest request){
        return getMeasurementPoint(request);
    }

}
