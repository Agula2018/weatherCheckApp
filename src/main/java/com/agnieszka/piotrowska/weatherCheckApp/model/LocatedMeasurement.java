package com.agnieszka.piotrowska.weatherCheckApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties
@Data
public class LocatedMeasurement {

    private MeasurementHistory measurement;
    private Installations installations;

}
