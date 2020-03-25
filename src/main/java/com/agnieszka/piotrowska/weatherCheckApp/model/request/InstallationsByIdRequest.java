package com.agnieszka.piotrowska.weatherCheckApp.model.request;

import lombok.Builder;

@Builder(toBuilder = true)
public class InstallationsByIdRequest {

    private int installationId;
}
