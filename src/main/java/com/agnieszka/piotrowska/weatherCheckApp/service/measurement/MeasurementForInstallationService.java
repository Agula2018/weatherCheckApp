package com.agnieszka.piotrowska.weatherCheckApp.service.measurement;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementForInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementForInstallationRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.RequestForExternalAPI;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.MeasurementForInstallationResponse;
import com.agnieszka.piotrowska.weatherCheckApp.parser.Parser;
import com.agnieszka.piotrowska.weatherCheckApp.service.AbstractExternalAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MeasurementForInstallationService extends AbstractExternalAPIService<MeasurementForInstallationRequest> {

    private static final String DOMAIN_PATH = "measurements/installation";
    private Parser <MeasurementForInstallationResponse[], List<MeasurementForInstallationDto>> dtoParser;

    @Autowired
    public MeasurementForInstallationService(RestTemplate restTemplate,
                                             @Qualifier ("measurementForInstallationParser")
                                                         Parser <MeasurementForInstallationResponse[],
                                                                 List<MeasurementForInstallationDto>> dtoParser) {
        super(restTemplate);
        this.dtoParser = dtoParser;
    }

    List<MeasurementForInstallationDto> getMeasurementForInstallation (MeasurementForInstallationRequest request){
        RequestForExternalAPI<MeasurementForInstallationRequest, MeasurementForInstallationResponse[]> requestObject =
                RequestForExternalAPI.<MeasurementForInstallationRequest, MeasurementForInstallationResponse[]>builder()
                        .requestObject(request)
                        .responseClass(MeasurementForInstallationResponse[].class)
                        .isQueryParam(true)
                        .build();
       return dtoParser.toDto(getFromRequest(requestObject));
    }

    @Override
    protected String getDomainPath() {
        return DOMAIN_PATH;
    }
}
