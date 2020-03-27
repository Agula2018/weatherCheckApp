package com.agnieszka.piotrowska.weatherCheckApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import java.util.List;

@JsonIgnoreProperties
@Data
public class MeasurementHistory {

    private SingleMeasurement current;
    private List <SingleMeasurement> history;
    private List <SingleMeasurement> forecast;
}
