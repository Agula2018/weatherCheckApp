package com.agnieszka.piotrowska.weatherCheckApp.parser;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementNearestDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.MeasurementNearestResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service("measurementNearestParser")
public class MeasurementNearestParser implements Parser<MeasurementNearestResponse[], List<MeasurementNearestDto>> {


    @Override
    public List<MeasurementNearestDto> toDto(MeasurementNearestResponse[] measurementNearestResponse) {
        return Arrays.stream(measurementNearestResponse).map(
                e ->
                        MeasurementNearestDto.builder()
                                .current(e.getCurrent())
                                .history(e.getHistory())
                                .forecast(e.getForecast())
                                .build()
        ).collect(Collectors.toList());
    }
}
