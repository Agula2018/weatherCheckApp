package com.agnieszka.piotrowska.weatherCheckApp.model;

import lombok.Data;

@Data
public class Installations {

    private Integer id;
    private Location location;
    private Address address;
    private Double elevation;
    private boolean airly;
    private Sponsor sponsor;


}
