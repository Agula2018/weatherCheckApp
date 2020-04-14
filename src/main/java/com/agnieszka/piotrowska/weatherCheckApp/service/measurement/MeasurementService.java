package com.agnieszka.piotrowska.weatherCheckApp.service.measurement;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementForInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementNearestDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementPointDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementForInstallationRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementNearestRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementPointRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public List<MeasurementForInstallationDto> getMeasurementForInstallation(MeasurementForInstallationRequest request){
        return measurementForInstallationService.getMeasurementForInstallation(request);
    }

    public List<MeasurementNearestDto> getMeasurementNearest(MeasurementNearestRequest request){
        return measurementNearestService.getMeasurementNearest(request);
    }
    public List <MeasurementPointDto> getMeasurementPoint(MeasurementPointRequest request){
        return measurementPointService.getMeasurementPoint(request);
    }
}
