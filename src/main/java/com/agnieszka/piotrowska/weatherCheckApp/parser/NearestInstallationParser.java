package com.agnieszka.piotrowska.weatherCheckApp.parser;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.NearestInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.NearestInstallationResponse;
import org.springframework.stereotype.Service;

@Service("nearestInstallationParser")
public class NearestInstallationParser implements Parser<NearestInstallationResponse, NearestInstallationDto> {

    @Override
    public NearestInstallationDto toDto(NearestInstallationResponse nearestInstallationResponse) {
        return NearestInstallationDto.builder()
                .id(nearestInstallationResponse.getId())
                .location(nearestInstallationResponse.getLocation())
                .address(nearestInstallationResponse.getAddress())
                .build();
    }
}
