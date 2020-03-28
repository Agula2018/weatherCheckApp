package com.agnieszka.piotrowska.weatherCheckApp.model.request;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class RequestForExternalAPI<REQUEST, RESPONSE> {

    private REQUEST requestObject;
    private Class<RESPONSE> responseClass;
    private boolean isQueryParam;
}
