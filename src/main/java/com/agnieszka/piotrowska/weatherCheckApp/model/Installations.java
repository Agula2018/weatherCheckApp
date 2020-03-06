package com.agnieszka.piotrowska.weatherCheckApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Installations {

    private double latitude;
    private double longitude;
    private double maxDistanceKM;
    private int maxResults;

}
