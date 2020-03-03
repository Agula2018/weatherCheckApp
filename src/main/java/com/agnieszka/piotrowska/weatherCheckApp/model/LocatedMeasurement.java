package com.agnieszka.piotrowska.weatherCheckApp.model;

import lombok.Data;

@Data
public class LocatedMeasurement {

    private Measurement measurement;
    private Installation installation;

}
