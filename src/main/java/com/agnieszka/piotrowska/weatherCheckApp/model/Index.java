package com.agnieszka.piotrowska.weatherCheckApp.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Index {

    private String name;
    private Double value;
    private String level;
    private String description;
    private String advice;
    private String color;
}
