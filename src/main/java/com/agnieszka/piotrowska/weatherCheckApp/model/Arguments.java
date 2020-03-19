package com.agnieszka.piotrowska.weatherCheckApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties
@Data
public class Arguments {

    public Integer installationId;
    public Double lat;
    public Double lng;
    public Double maxDistanceKm;
    public Integer maxResults;
}
