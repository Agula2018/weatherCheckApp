package com.agnieszka.piotrowska.weatherCheckApp.model.request;

import lombok.Builder;

@Builder(toBuilder = true)
public class MeasurementPointRequest {

    private String indexType;
    private double latitude;
    private double longitude;
}
