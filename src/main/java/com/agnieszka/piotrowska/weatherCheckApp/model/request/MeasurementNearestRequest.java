package com.agnieszka.piotrowska.weatherCheckApp.model.request;

import lombok.Builder;

@Builder(toBuilder = true)
public class MeasurementNearestRequest {

    private String indexType;
    private double longitude;
    private double latitude;
    private double maxDistanceKM;
}
