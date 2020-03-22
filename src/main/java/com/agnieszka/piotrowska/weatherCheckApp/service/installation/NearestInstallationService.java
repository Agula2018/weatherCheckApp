package com.agnieszka.piotrowska.weatherCheckApp.service.installation;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.NearestInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.NearestInstallationRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.NearestInstallationResponse;
import com.agnieszka.piotrowska.weatherCheckApp.service.AbstractExternalAPIService;
import org.springframework.stereotype.Service;

@Service
class NearestInstallationService extends AbstractExternalAPIService<NearestInstallationResponse> {

    NearestInstallationDto getNearestInstallation(NearestInstallationRequest request){
        NearestInstallationResponse res = get("", NearestInstallationResponse.class).getBody();
        //BUSINESS LOGIC
        return /* mock */ new NearestInstallationDto();
    }
}
