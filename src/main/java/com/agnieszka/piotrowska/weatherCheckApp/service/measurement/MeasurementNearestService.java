package com.agnieszka.piotrowska.weatherCheckApp.service.measurement;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementNearestDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementNearestRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.RequestForExternalAPI;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.MeasurementNearestResponse;
import com.agnieszka.piotrowska.weatherCheckApp.parser.Parser;
import com.agnieszka.piotrowska.weatherCheckApp.service.AbstractExternalAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MeasurementNearestService extends AbstractExternalAPIService <MeasurementNearestRequest> {

    private static final String DOMAIN_PATH = "measurements/nearest";
    private Parser <MeasurementNearestResponse [], List<MeasurementNearestDto>> dtoParser;

    @Autowired
    public MeasurementNearestService(RestTemplate restTemplate,
                                     @Qualifier("measurementNearestParser")
                                     Parser<MeasurementNearestResponse[], List<MeasurementNearestDto>> dtoParser) {
        super(restTemplate);
        this.dtoParser = dtoParser;
    }

    List<MeasurementNearestDto> getMeasurementNearest(MeasurementNearestRequest request){
        RequestForExternalAPI<MeasurementNearestRequest, MeasurementNearestResponse[]> requestObject =
                RequestForExternalAPI.<MeasurementNearestRequest, MeasurementNearestResponse[]>builder()
                        .requestObject(request)
                        .responseClass(MeasurementNearestResponse[].class)
                        .isQueryParam(true)
                        .build();
        return dtoParser.toDto(getFromRequest(requestObject));
    }

    @Override
    protected String getDomainPath() {
        return DOMAIN_PATH;
    }
}
