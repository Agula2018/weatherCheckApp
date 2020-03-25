package com.agnieszka.piotrowska.weatherCheckApp.service.measurement;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementNearestDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementNearestRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.MeasurementNearestResponse;
import com.agnieszka.piotrowska.weatherCheckApp.service.AbstractExternalAPIService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MeasurementNearestService extends AbstractExternalAPIService<MeasurementNearestRequest> {

    public MeasurementNearestService(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    protected String getDomainPath() {
        return null;
    }

    @Override
    protected String buildURLParams(MeasurementNearestRequest request) {
        return null;
    }

    MeasurementNearestDto getMeasurementNearest(MeasurementNearestRequest request){
        MeasurementNearestResponse response = get("https://airapi.airly.eu/v2/measurements/nearest",
                MeasurementNearestResponse.class).getBody();
        return new MeasurementNearestDto();
    }
}
