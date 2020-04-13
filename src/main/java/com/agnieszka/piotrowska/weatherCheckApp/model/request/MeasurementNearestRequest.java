package com.agnieszka.piotrowska.weatherCheckApp.model.request;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class MeasurementNearestRequest {

    private String indexType;
    private Double lat;
    private Double lng;
    private Integer maxDistanceKM;
}
