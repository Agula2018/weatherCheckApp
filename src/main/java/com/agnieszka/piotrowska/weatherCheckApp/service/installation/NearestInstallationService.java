package com.agnieszka.piotrowska.weatherCheckApp.service.installation;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.NearestInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.NearestInstallationRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.NearestInstallationResponse;
import com.agnieszka.piotrowska.weatherCheckApp.service.AbstractExternalAPIService;
import com.agnieszka.piotrowska.weatherCheckApp.util.URLUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.StringJoiner;

@Service
class NearestInstallationService extends AbstractExternalAPIService<NearestInstallationRequest> {

    private static final String DOMAIN_PATH = "installations/nearest";

    public NearestInstallationService(RestTemplate restTemplate) {
        super(restTemplate);
    }


    NearestInstallationDto getNearestInstallation(NearestInstallationRequest request){
        NearestInstallationResponse response = getFromRequest(request, NearestInstallationResponse.class);

        return /* mock */ new NearestInstallationDto();
    }

    @Override
    protected String getDomainPath() {
        return getBaseURL() + DOMAIN_PATH;
    }

}
