package com.agnieszka.piotrowska.weatherCheckApp.model.dto;

import com.agnieszka.piotrowska.weatherCheckApp.model.response.SingleMeasurement;
import lombok.Data;
import java.util.List;

@Data
public class MeasurementPointDto {

    private SingleMeasurement current;
    private List<SingleMeasurement> history;
    private List <SingleMeasurement> forecast;

}
