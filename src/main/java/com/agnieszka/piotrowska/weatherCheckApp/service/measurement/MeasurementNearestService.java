package com.agnieszka.piotrowska.weatherCheckApp.service.measurement;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementNearestDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementNearestRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.MeasurementNearestResponse;
import com.agnieszka.piotrowska.weatherCheckApp.service.AbstractExternalAPIService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MeasurementNearestService extends AbstractExternalAPIService <MeasurementNearestRequest> {

    private static final String DOMAIN_PATH = "measurements/nearest";

    public MeasurementNearestService(RestTemplate restTemplate) {
        super(restTemplate);
    }

    MeasurementNearestDto getMeasurementNearest(MeasurementNearestRequest request){
        MeasurementNearestResponse response = getFromRequest(request, MeasurementNearestResponse.class);
        return new MeasurementNearestDto();
    }

    @Override
    protected String getDomainPath() {
        return getBaseURL() + DOMAIN_PATH;
    }
}
