package com.agnieszka.piotrowska.weatherCheckApp.parser;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementNearestDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.MeasurementNearestResponse;
import org.springframework.stereotype.Service;

@Service("measurementNearestParser")
public class MeasurementNearestParser implements Parser<MeasurementNearestResponse, MeasurementNearestDto> {


    @Override
    public MeasurementNearestDto toDto(MeasurementNearestResponse measurementNearestResponse) {
        return MeasurementNearestDto.builder()
                .current(measurementNearestResponse.getCurrent())
                .history(measurementNearestResponse.getHistory())
                .forecast(measurementNearestResponse.getForecast())
                .build();
    }
}
