package com.agnieszka.piotrowska.weatherCheckApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Standards {

    private String name;
    private String pollutant;
    private Double limit;
    private Double percent;

}
