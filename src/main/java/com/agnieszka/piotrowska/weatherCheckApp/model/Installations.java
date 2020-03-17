package com.agnieszka.piotrowska.weatherCheckApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties
@Data
public class Installations {

    private Long id;
    private Location location;
    private Address address;
    private Double elevation;
    private Boolean airly;
    private Sponsor sponsor;


}
