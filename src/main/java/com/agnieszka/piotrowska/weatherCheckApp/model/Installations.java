package com.agnieszka.piotrowska.weatherCheckApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Installations {

    private Integer id;
    private Double latitude;
    private Double longitude;
    private Address address;
    private Double elevation;
    private Boolean airly;
    private Sponsor sponsor;
}
