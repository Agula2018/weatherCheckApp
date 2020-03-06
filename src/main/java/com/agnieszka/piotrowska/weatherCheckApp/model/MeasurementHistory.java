package com.agnieszka.piotrowska.weatherCheckApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@JsonIgnoreProperties
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MeasurementHistory {

    private SingleMeasurement current;
    private List <SingleMeasurement> history;
    private List <SingleMeasurement> forecast;
}
