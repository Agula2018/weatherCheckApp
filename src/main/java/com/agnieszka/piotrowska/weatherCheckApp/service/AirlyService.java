package com.agnieszka.piotrowska.weatherCheckApp.service;

import com.agnieszka.piotrowska.weatherCheckApp.service.installation.InstallationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlyService {

    private InstallationsService installationsService;

    @Autowired
    public AirlyService(InstallationsService installationsService) {
        this.installationsService = installationsService;
    }

    //METHODS FOR GETTING INFOS FROM AIRLY
}

