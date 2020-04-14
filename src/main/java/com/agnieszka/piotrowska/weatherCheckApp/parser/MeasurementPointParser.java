package com.agnieszka.piotrowska.weatherCheckApp.parser;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementPointDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.MeasurementPointResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service("measurementPointParser")
public class MeasurementPointParser implements Parser<MeasurementPointResponse[], List<MeasurementPointDto>> {


    @Override
    public List<MeasurementPointDto> toDto(MeasurementPointResponse[] measurementPointResponse) {
        return Arrays.stream(measurementPointResponse).map(
                e ->
                        MeasurementPointDto.builder()
                                .current(e.getCurrent())
                                .history(e.getHistory())
                                .forecast(e.getForecast())
                .build()
        ).collect(Collectors.toList());
    }
}
