package com.agnieszka.piotrowska.weatherCheckApp.model;

import lombok.Data;

import java.util.List;

@Data
public class MeasurementHistory {

    private SingleMeasurement current;
    private List <SingleMeasurement> history;
    private List <SingleMeasurement> forecast;
}
