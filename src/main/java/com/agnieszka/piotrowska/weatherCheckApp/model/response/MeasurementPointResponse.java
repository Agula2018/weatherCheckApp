package com.agnieszka.piotrowska.weatherCheckApp.model.response;

import lombok.Data;
import java.util.List;

@Data
public class MeasurementPointResponse {

    private SingleMeasurement current;
    private List<SingleMeasurement> history;
    private List <SingleMeasurement> forecast;
}
