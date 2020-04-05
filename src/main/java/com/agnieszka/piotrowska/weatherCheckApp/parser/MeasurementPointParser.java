package com.agnieszka.piotrowska.weatherCheckApp.parser;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementPointDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.MeasurementPointResponse;
import org.springframework.stereotype.Service;

@Service("measurementPointParser")
public class MeasurementPointParser implements Parser <MeasurementPointResponse, MeasurementPointDto> {


    @Override
    public MeasurementPointDto toDto(MeasurementPointResponse measurementPointResponse) {
        return MeasurementPointDto.builder()
                .current(measurementPointResponse.getCurrent())
                .history(measurementPointResponse.getHistory())
                .forecast(measurementPointResponse.getForecast())
                .build();
    }
}
