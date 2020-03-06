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
public class Arguments {

    public String apiKey;
    public Integer installationId;
    public Double lat;
    public Double lng;
    public Double maxDistanceKm;
    public Integer maxResults;
}
