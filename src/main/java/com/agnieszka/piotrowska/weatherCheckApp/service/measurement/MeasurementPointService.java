package com.agnieszka.piotrowska.weatherCheckApp.service.measurement;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementPointDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementPointRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.MeasurementPointResponse;
import com.agnieszka.piotrowska.weatherCheckApp.service.AbstractExternalAPIService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MeasurementPointService extends AbstractExternalAPIService <MeasurementPointResponse> {

    public MeasurementPointService(RestTemplate restTemplate) {
        super(restTemplate);
    }

    MeasurementPointDto getMeasurementPoint (MeasurementPointRequest request){
        MeasurementPointResponse response = get("https://airapi.airly.eu/v2/measurements/point",
                MeasurementPointResponse.class).getBody();
        return new MeasurementPointDto();
    }
}
