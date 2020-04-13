package com.agnieszka.piotrowska.weatherCheckApp.model.request;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class NearestInstallationRequest {

    private Double lat;
    private Double lng;
    private Integer maxDistanceKM;
    private Integer maxResults;

}
