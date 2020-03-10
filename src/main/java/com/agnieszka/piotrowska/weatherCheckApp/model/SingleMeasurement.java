package com.agnieszka.piotrowska.weatherCheckApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@JsonIgnoreProperties
@Data
public class SingleMeasurement {

    private String fromDateTime;
    private String tillDateTime;
    private List<Value> values;
    private List <Index> indexes;
    private List <Standards> standards;

}
