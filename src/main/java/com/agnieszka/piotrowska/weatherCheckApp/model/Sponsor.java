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
public class Sponsor {

    private Integer sponsorId;
    private String name;
    private String description;
    private String logo;
    private String link;

}
