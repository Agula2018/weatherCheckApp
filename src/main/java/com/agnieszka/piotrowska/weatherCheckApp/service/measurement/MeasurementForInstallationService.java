package com.agnieszka.piotrowska.weatherCheckApp.service.measurement;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementForInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementForInstallationRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.RequestForExternalAPI;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.MeasurementForInstallationResponse;
import com.agnieszka.piotrowska.weatherCheckApp.service.AbstractExternalAPIService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MeasurementForInstallationService extends AbstractExternalAPIService<MeasurementForInstallationRequest> {

    private static final String DOMAIN_PATH = "measurements/installation";

    public MeasurementForInstallationService(RestTemplate restTemplate) {
        super(restTemplate);
    }

    MeasurementForInstallationDto getMeasurementForInstallation (MeasurementForInstallationRequest request){
        RequestForExternalAPI<MeasurementForInstallationRequest, MeasurementForInstallationResponse> requestObject =
                RequestForExternalAPI.<MeasurementForInstallationRequest, MeasurementForInstallationResponse>builder()
                        .requestObject(request)
                        .responseClass(MeasurementForInstallationResponse.class)
                        .isQueryParam(true)
                        .build();
        MeasurementForInstallationResponse response = getFromRequest(requestObject);
        return new MeasurementForInstallationDto();
    }
    @Override
    protected String getDomainPath() {
        return DOMAIN_PATH;
    }
}
