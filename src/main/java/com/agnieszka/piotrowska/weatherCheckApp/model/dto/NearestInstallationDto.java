package com.agnieszka.piotrowska.weatherCheckApp.model.dto;

import com.agnieszka.piotrowska.weatherCheckApp.model.Address;
import com.agnieszka.piotrowska.weatherCheckApp.model.Location;
import com.agnieszka.piotrowska.weatherCheckApp.model.Sponsor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class NearestInstallationDto {

    private Integer id;
    private Location location;
    private Address address;
    private Double elevation;
    private boolean airly;
    private Sponsor sponsor;
}
