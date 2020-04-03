package com.agnieszka.piotrowska.weatherCheckApp.parser;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.InstallationsByIdDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.InstallationByIdResponse;
import org.springframework.stereotype.Service;

@Service("installationByIdParser")
public class InstallationByIdParser implements Parser<InstallationByIdResponse, InstallationsByIdDto> {

    @Override
    public InstallationsByIdDto toDto(InstallationByIdResponse installationByIdResponse) {
        return InstallationsByIdDto.builder()
                .address(installationByIdResponse.getAddress())
                .airly(installationByIdResponse.getAirly())
                .elevation(installationByIdResponse.getElevation())
                .location(installationByIdResponse.getLocation())
                .sponsor(installationByIdResponse.getSponsor())
                .build();
    }
}
