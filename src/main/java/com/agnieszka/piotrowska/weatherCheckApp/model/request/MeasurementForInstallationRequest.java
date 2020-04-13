package com.agnieszka.piotrowska.weatherCheckApp.model.request;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class MeasurementForInstallationRequest {

    private String indexType;
    private Integer installationId;

}
