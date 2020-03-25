package com.agnieszka.piotrowska.weatherCheckApp.service.measurement;

import com.agnieszka.piotrowska.weatherCheckApp.model.dto.MeasurementForInstallationDto;
import com.agnieszka.piotrowska.weatherCheckApp.model.request.MeasurementForInstallationRequest;
import com.agnieszka.piotrowska.weatherCheckApp.model.response.MeasurementForInstallationResponse;
import com.agnieszka.piotrowska.weatherCheckApp.service.AbstractExternalAPIService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MeasurementForInstallationService extends AbstractExternalAPIService <MeasurementForInstallationResponse> {

    public MeasurementForInstallationService(RestTemplate restTemplate) {
        super(restTemplate);
    }

    MeasurementForInstallationDto getMeasurementsForInstallation (MeasurementForInstallationRequest request){
        MeasurementForInstallationResponse response = get("https://airapi.airly.eu/v2/measurements/installation",
                MeasurementForInstallationResponse.class).getBody();
        return new MeasurementForInstallationDto();
    }
}
