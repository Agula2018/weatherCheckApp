package com.agnieszka.piotrowska.weatherCheckApp.service.installation;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.NearestInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.InstallationsByIdRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.NearestInstallationRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.RequestForExternalAPI;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.InstallationByIdResponse;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.NearestInstallationResponse;
import com.agnieszka.piotrowska.weatherCheckApp.service.AbstractExternalAPIService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
class NearestInstallationService extends AbstractExternalAPIService<NearestInstallationRequest> {

    private static final String DOMAIN_PATH = "installations/nearest";

    public NearestInstallationService(RestTemplate restTemplate) {
        super(restTemplate);
    }

    NearestInstallationDto getNearestInstallation(NearestInstallationRequest request){
        RequestForExternalAPI<NearestInstallationRequest, NearestInstallationResponse> requestObject =
                RequestForExternalAPI.<NearestInstallationRequest, NearestInstallationResponse>builder()
                        .requestObject(request)
                        .responseClass(NearestInstallationResponse.class)
                        .isQueryParam(true)
                        .build();
        NearestInstallationResponse response = getFromRequest(requestObject);

        return /* mock */ new NearestInstallationDto();
    }

    @Override
    protected String getDomainPath() {
        return getBaseURL() + DOMAIN_PATH;
    }
}
