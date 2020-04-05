package com.agnieszka.piotrowska.weatherCheckApp.parser;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementForInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.MeasurementForInstallationResponse;
import org.springframework.stereotype.Service;

@Service("measurementForInstallationParser")
public class MeasurementForInstallationParser implements Parser<MeasurementForInstallationResponse, MeasurementForInstallationDto> {

    @Override
    public MeasurementForInstallationDto toDto(MeasurementForInstallationResponse measurementForInstallationResponse) {
        return MeasurementForInstallationDto.builder()
                .current(measurementForInstallationResponse.getCurrent())
                .history(measurementForInstallationResponse.getHistory())
                .forecast(measurementForInstallationResponse.getForecast())
                .build();
    }
}
