package com.agnieszka.piotrowska.weatherCheckApp.model;
import lombok.Data;

@Data
public class Index {

    private String name;
    private Double value;
    private String level;
    private String description;
    private String advice;
    private String color;
}
