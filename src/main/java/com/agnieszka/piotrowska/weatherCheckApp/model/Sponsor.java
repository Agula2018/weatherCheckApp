package com.agnieszka.piotrowska.weatherCheckApp.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties
@Data
public class Sponsor {

    private Long sponsorId;
    private String name;
    private String description;
    private String logo;
    private String link;

}
