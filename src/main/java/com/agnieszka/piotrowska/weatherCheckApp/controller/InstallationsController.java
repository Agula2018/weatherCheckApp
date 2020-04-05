package com.agnieszka.piotrowska.weatherCheckApp.controller;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.InstallationsByIdDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.dto.NearestInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.InstallationsByIdRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.NearestInstallationRequest;
import com.agnieszka.piotrowska.weatherCheckApp.service.installation.InstallationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v2/installations/")
public class InstallationsController {

    private InstallationsService installationsService;

    @Autowired
    public InstallationsController(InstallationsService installationsService) {
        this.installationsService = installationsService;
    }

    @GetMapping("nearest")
    public NearestInstallationDto handleNearestInstallation(@RequestParam("lat") double lat,
                                                            @RequestParam("lng") double lng,
                                                            @RequestParam("maxDistanceKM") int maxDistanceKM,
                                                            @RequestParam("maxResults") int maxResults) throws JsonParseException {
        NearestInstallationRequest request = NearestInstallationRequest.builder()
                .lat(lat)
                .lng(lng)
                .maxDistanceKm(maxDistanceKM)
                .maxResults(maxResults)
                .build();

        NearestInstallationDto dto = installationsService.getNearestInstallation(request);
        return dto;
    }

    @GetMapping("{installationId}")
    public InstallationsByIdDto handleInstallationId(@PathVariable("installationId") int installationId) throws JsonParseException {

        InstallationsByIdRequest request = InstallationsByIdRequest.builder()
                .installationId(installationId)
                .build();

        InstallationsByIdDto dto = installationsService.getInstallationsByIdDto(request);

        return dto;
    }
}