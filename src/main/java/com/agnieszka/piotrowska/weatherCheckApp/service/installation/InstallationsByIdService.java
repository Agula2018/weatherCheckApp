package com.agnieszka.piotrowska.weatherCheckApp.service.installation;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.InstallationsByIdDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.InstallationsByIdRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.RequestForExternalAPI;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.InstallationByIdResponse;
import com.agnieszka.piotrowska.weatherCheckApp.parser.Parser;
import com.agnieszka.piotrowska.weatherCheckApp.service.AbstractExternalAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InstallationsByIdService extends AbstractExternalAPIService<InstallationsByIdRequest> {

    private static final String DOMAIN_PATH = "installations/";
    private Parser<InstallationByIdResponse, InstallationsByIdDto> dtoParser;

    @Autowired
    public InstallationsByIdService(RestTemplate restTemplate,
                                    @Qualifier("installationByIdParser") Parser<InstallationByIdResponse,
                                            InstallationsByIdDto> dtoParser) {
        super(restTemplate);
        this.dtoParser = dtoParser;
    }

    InstallationsByIdDto getInstallationById(InstallationsByIdRequest request) {
        RequestForExternalAPI<InstallationsByIdRequest, InstallationByIdResponse> requestObject =
                RequestForExternalAPI.<InstallationsByIdRequest, InstallationByIdResponse>builder()
                        .requestObject(request)
                        .responseClass(InstallationByIdResponse.class)
                        .isQueryParam(false)
                        .build();
        return dtoParser.toDto(getFromRequest(requestObject));
    }

    @Override
    protected String getDomainPath() {
        return DOMAIN_PATH;
    }

}
