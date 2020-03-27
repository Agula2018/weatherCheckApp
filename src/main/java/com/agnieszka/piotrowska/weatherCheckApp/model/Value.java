package com.agnieszka.piotrowska.weatherCheckApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties
@Data
public class Value {

    private String name;
    private Double value;
}
