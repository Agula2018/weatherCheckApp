package com.agnieszka.piotrowska.weatherCheckApp.model;

import lombok.Data;

@Data
public class Standards {

    private String name;
    private String pollutant;
    private Double limit;
    private Double percent;

}
