package com.agnieszka.piotrowska.weatherCheckApp.service.installation;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.InstallationsByIdDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.InstallationsByIdRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.InstallationByIdResponse;
import com.agnieszka.piotrowska.weatherCheckApp.service.AbstractExternalAPIService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InstallationsByIdService extends AbstractExternalAPIService<InstallationByIdResponse> {

    public InstallationsByIdService(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    protected String getDomainPath() {
        return null;
    }

    @Override
    protected String buildURLParams(InstallationByIdResponse request) {
        return null;
    }

    InstallationsByIdDto getInstallationById(InstallationsByIdRequest request){
        InstallationByIdResponse response = get("https://airapi.airly.eu/v2/installations",
                InstallationByIdResponse.class).getBody();
        return new InstallationsByIdDto();
    }
}
