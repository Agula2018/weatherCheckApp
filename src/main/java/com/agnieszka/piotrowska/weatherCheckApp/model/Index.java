package com.agnieszka.piotrowska.weatherCheckApp.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties
@Data
public class Index {

    private String name;
    private Double value;
    private String level;
    private String description;
    private String advice;
    private String color;
}
