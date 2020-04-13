package com.agnieszka.piotrowska.weatherCheckApp.service.installation;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.InstallationsByIdDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.dto.NearestInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.InstallationsByIdRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.NearestInstallationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstallationsService {

    private NearestInstallationService nearestInstallationService;
    private InstallationsByIdService installationsByIdService;

    @Autowired
    public InstallationsService(NearestInstallationService nearestInstallationService,
                                InstallationsByIdService installationsByIdService) {
        this.nearestInstallationService = nearestInstallationService;
        this.installationsByIdService = installationsByIdService;
    }

    public List<NearestInstallationDto> getNearestInstallation(NearestInstallationRequest request){
        return nearestInstallationService.getNearestInstallation(request);
    }

    public InstallationsByIdDto getInstallationsByIdDto(InstallationsByIdRequest request){
        return installationsByIdService.getInstallationById(request);
    }
}
