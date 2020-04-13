package com.agnieszka.piotrowska.weatherCheckApp.model;

import lombok.Data;

import java.util.List;

@Data
public class SingleMeasurement {

    private String fromDateTime;
    private String tillDateTime;
    private List <Value> values;
    private List <Index> indexes;
    private List <Standards> standards;

}
