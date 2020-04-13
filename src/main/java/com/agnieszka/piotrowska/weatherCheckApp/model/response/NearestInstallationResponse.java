package com.agnieszka.piotrowska.weatherCheckApp.model.response;

import com.agnieszka.piotrowska.weatherCheckApp.model.Address;
import com.agnieszka.piotrowska.weatherCheckApp.model.Location;
import com.agnieszka.piotrowska.weatherCheckApp.model.Sponsor;
import lombok.Data;

@Data
public class NearestInstallationResponse {

    private Integer id;
    private Location location;
    private Address address;
    private Double elevation;
    private boolean airly;
    private Sponsor sponsor;
}
