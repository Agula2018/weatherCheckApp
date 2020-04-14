package com.agnieszka.piotrowska.weatherCheckApp.parser;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.NearestInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.NearestInstallationResponse;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service("nearestInstallationParser")
public class NearestInstallationParser implements Parser<NearestInstallationResponse[], List<NearestInstallationDto>> {

    @Override
    public List<NearestInstallationDto> toDto(NearestInstallationResponse[] nearestInstallationResponse) {
       return Arrays.stream(nearestInstallationResponse).map(
                e ->
                    NearestInstallationDto.builder()
                            .id(e.getId())
                            .location(e.getLocation())
                            .address(e.getAddress())
                            .build()
        ).collect(Collectors.toList());
    }
}
