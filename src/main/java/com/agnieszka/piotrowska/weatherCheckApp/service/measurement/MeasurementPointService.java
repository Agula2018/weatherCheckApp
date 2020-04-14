package com.agnieszka.piotrowska.weatherCheckApp.service.measurement;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementPointDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementPointRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.RequestForExternalAPI;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.MeasurementPointResponse;
import com.agnieszka.piotrowska.weatherCheckApp.parser.Parser;
import com.agnieszka.piotrowska.weatherCheckApp.service.AbstractExternalAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MeasurementPointService extends AbstractExternalAPIService<MeasurementPointRequest> {

    private static final String DOMAIN_PATH = "measurements/point";
    private Parser<MeasurementPointResponse[], List<MeasurementPointDto>> dtoParser;

    @Autowired
    public MeasurementPointService(RestTemplate restTemplate,
                                   @Qualifier("measurementPointParser")
                                   Parser<MeasurementPointResponse[], List<MeasurementPointDto>> dtoParser) {
        super(restTemplate);
        this.dtoParser = dtoParser;
    }

    List<MeasurementPointDto> getMeasurementPoint(MeasurementPointRequest request) {
        RequestForExternalAPI<MeasurementPointRequest, MeasurementPointResponse[]> requestObject =
                RequestForExternalAPI.<MeasurementPointRequest, MeasurementPointResponse[]>builder()
                        .requestObject(request)
                        .responseClass(MeasurementPointResponse[].class)
                        .isQueryParam(true)
                        .build();
       return dtoParser.toDto(getFromRequest(requestObject));
    }

    @Override
    protected String getDomainPath() {
        return DOMAIN_PATH;
    }
}
