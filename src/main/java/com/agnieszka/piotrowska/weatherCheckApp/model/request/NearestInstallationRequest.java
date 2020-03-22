package com.agnieszka.piotrowska.weatherCheckApp.model.request;

import lombok.Builder;

@Builder(toBuilder = true)
public class NearestInstallationRequest {

    private double latitude;
    private double longitude;
    private double maxDistanceKm;
    private int maxResults;

}
