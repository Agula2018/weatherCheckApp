package com.agnieszka.piotrowska.weatherCheckApp.service.installation;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.InstallationsByIdDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.InstallationsByIdRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.InstallationByIdResponse;
import com.agnieszka.piotrowska.weatherCheckApp.service.AbstractExternalAPIService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InstallationsByIdService extends AbstractExternalAPIService<InstallationsByIdRequest> {

    private static final String DOMAIN_PATH = "installations/";

    public InstallationsByIdService(RestTemplate restTemplate) {
        super(restTemplate);
    }

    InstallationsByIdDto getInstallationById(InstallationsByIdRequest request){
        InstallationByIdResponse response = getFromRequest(request, InstallationByIdResponse.class);
        return new InstallationsByIdDto();
    }

    @Override
    protected String getDomainPath() {
        return getBaseURL() + DOMAIN_PATH;
    }
}
