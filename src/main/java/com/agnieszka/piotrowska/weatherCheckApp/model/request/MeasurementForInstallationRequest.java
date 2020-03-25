package com.agnieszka.piotrowska.weatherCheckApp.model.request;

import lombok.Builder;

@Builder(toBuilder = true)
public class MeasurementForInstallationRequest {

    private String indexType;
    private int installationId;

}
