package com.agnieszka.piotrowska.weatherCheckApp.model.dto;

import com.agnieszka.piotrowska.weatherCheckApp.model.Address;
import com.agnieszka.piotrowska.weatherCheckApp.model.Location;
import com.agnieszka.piotrowska.weatherCheckApp.model.Sponsor;
import lombok.Data;

@Data
public class InstallationsByIdDto {

    private Long id;
    private Location location;
    private Address address;
    private Double elevation;
    private Boolean airly;
    private Sponsor sponsor;
}
