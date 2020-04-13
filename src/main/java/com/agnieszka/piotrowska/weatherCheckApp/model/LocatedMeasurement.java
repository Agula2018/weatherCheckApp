package com.agnieszka.piotrowska.weatherCheckApp.model;

import lombok.Data;

@Data
public class LocatedMeasurement {

    private MeasurementHistory measurement;
    private Installations installations;

}
