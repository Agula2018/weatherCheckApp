package com.agnieszka.piotrowska.weatherCheckApp.service.installation;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.NearestInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.NearestInstallationRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.NearestInstallationResponse;
import com.agnieszka.piotrowska.weatherCheckApp.service.AbstractExternalAPIService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
class NearestInstallationService extends AbstractExternalAPIService<NearestInstallationResponse> {

    public NearestInstallationService(RestTemplate restTemplate) {
        super(restTemplate);
    }

    NearestInstallationDto getNearestInstallation(NearestInstallationRequest request){
        NearestInstallationResponse response = get("https://airapi.airly.eu/v2/installations/nearest",
                NearestInstallationResponse.class).getBody();
        return /* mock */ new NearestInstallationDto();
    }
}
