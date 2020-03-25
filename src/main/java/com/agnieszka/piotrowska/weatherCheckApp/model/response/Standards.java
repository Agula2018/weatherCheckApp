package com.agnieszka.piotrowska.weatherCheckApp.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties
@Data
public class Standards {

    private String name;
    private String pollutant;
    private Double limit;
    private Double percent;

}
