package com.agnieszka.piotrowska.weatherCheckApp.service.installation;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.NearestInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.NearestInstallationRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.RequestForExternalAPI;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.NearestInstallationResponse;
import com.agnieszka.piotrowska.weatherCheckApp.parser.Parser;
import com.agnieszka.piotrowska.weatherCheckApp.service.AbstractExternalAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NearestInstallationService extends AbstractExternalAPIService<NearestInstallationRequest> {

    private static final String DOMAIN_PATH = "installations/nearest";
    private Parser<NearestInstallationResponse, NearestInstallationDto> dtoParser;

    @Autowired
    public NearestInstallationService(RestTemplate restTemplate,
                                      @Qualifier("nearestInstallationParser") Parser <NearestInstallationResponse,
                                              NearestInstallationDto> dtoParser) {
        super(restTemplate);
        this.dtoParser = dtoParser;
    }

    NearestInstallationDto getNearestInstallation(NearestInstallationRequest request){
        RequestForExternalAPI<NearestInstallationRequest, NearestInstallationResponse> requestObject =
                RequestForExternalAPI.<NearestInstallationRequest, NearestInstallationResponse>builder()
                        .requestObject(request)
                        .responseClass(NearestInstallationResponse.class)
                        .isQueryParam(true)
                        .build();
       return dtoParser.toDto(getFromRequest(requestObject));
    }

    @Override
    protected String getDomainPath() {
        return DOMAIN_PATH;
    }
}

