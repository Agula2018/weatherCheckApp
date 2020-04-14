package com.agnieszka.piotrowska.weatherCheckApp.parser;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementForInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.MeasurementForInstallationResponse;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service("measurementForInstallationParser")
public class MeasurementForInstallationParser implements Parser<MeasurementForInstallationResponse[], List<MeasurementForInstallationDto>> {

    @Override
    public List<MeasurementForInstallationDto> toDto(MeasurementForInstallationResponse[] measurementForInstallationResponse) {
        return Arrays.stream(measurementForInstallationResponse).map(
                e ->
                        MeasurementForInstallationDto.builder()
                        .current(e.getCurrent())
                        .history(e.getHistory())
                        .forecast(e.getForecast())
                        .build()
        ).collect(Collectors.toList());


    }
}
