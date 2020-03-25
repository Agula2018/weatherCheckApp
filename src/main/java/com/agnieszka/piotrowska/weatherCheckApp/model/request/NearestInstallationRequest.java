package com.agnieszka.piotrowska.weatherCheckApp.model.request;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class NearestInstallationRequest {

    private double latitude;
    private double longitude;
    private int maxDistanceKm;
    private int maxResults;

}
