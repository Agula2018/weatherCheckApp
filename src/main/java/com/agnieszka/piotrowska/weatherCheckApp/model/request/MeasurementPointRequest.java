package com.agnieszka.piotrowska.weatherCheckApp.model.request;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class MeasurementPointRequest {

    private String indexType;
    private double lat;
    private double lng;
}
