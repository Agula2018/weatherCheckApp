package com.agnieszka.piotrowska.weatherCheckApp.service.measurement;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementPointDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementPointRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.MeasurementPointResponse;
import com.agnieszka.piotrowska.weatherCheckApp.service.AbstractExternalAPIService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MeasurementPointService extends AbstractExternalAPIService<MeasurementPointRequest> {

    private static final String DOMAIN_PATH = "measurements/point";

    public MeasurementPointService(RestTemplate restTemplate) {
        super(restTemplate);
    }


    MeasurementPointDto getMeasurementPoint (MeasurementPointRequest request){
        MeasurementPointResponse response = getFromRequest(request, MeasurementPointResponse.class);
        return new MeasurementPointDto();
    }

    @Override
    protected String getDomainPath() {
        return getBaseURL() + DOMAIN_PATH;
    }
}
