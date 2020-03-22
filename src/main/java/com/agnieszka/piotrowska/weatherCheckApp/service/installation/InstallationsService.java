package com.agnieszka.piotrowska.weatherCheckApp.service.installation;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.NearestInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.NearestInstallationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstallationsService {

    private NearestInstallationService nearestInstallationService;

    @Autowired
    public InstallationsService(NearestInstallationService nearestInstallationService) {
        this.nearestInstallationService = nearestInstallationService;
    }


    public NearestInstallationDto getNearestInstallation(NearestInstallationRequest request){
        return getNearestInstallation(request);
    }
}
