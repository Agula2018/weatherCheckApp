package com.agnieszka.piotrowska.weatherCheckApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AirlyService {


    public RestTemplate restTemplate;
    public AbstractExternalAPIService abstractExternalAPIService;

    @Autowired
    public AirlyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("nearest")
    public ResponseEntity getInstallationsEndpoint(@RequestParam("lat") double lat,
                                                   @RequestParam("lng") double lng,
                                                   @RequestParam("maxDistanceKM") double maxDistanceKM,
                                                   @RequestParam("maxResults") int maxResults) throws JsonParseException {
        String url = "https://airapi.airly.eu/v2/installations/nearest";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("lat", lat)
                .queryParam("lng", lng)
                .queryParam("maxDistanceKM", maxDistanceKM)
                .queryParam("maxResults", maxResults);

        return abstractExternalAPIService.get(builder);
    }

    @GetMapping("{installationId}")
    public ResponseEntity getInstallationIdEndpoint(@PathVariable("installationId") int installationId) {
        String url = "https://airapi.airly.eu/v2/installations/";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("installationId", installationId);

        return abstractExternalAPIService.get(builder);
    }

    @GetMapping("installation")
    public ResponseEntity getDetailedMeasurementEndpoint(@RequestParam("indexType") String indexType,
                                                         @RequestParam("installationId") int installationId) throws JsonParseException {
        String url = "https://airapi.airly.eu/v2/measurements/installation";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("indexType", indexType)
                .queryParam("installationId", installationId);

        return abstractExternalAPIService.get(builder);
    }

    @GetMapping("nearest")
    public ResponseEntity getDetailedMeasurementNearestEndpoint(@RequestParam("indexType") String indexType,
                                                                @RequestParam("lat") double lat,
                                                                @RequestParam("lng") double lng,
                                                                @RequestParam("maxDistanceKM") double maxDistanceKM) throws JsonParseException {
        String url = "https://airapi.airly.eu/v2/measurements/nearest";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("indexType", indexType)
                .queryParam("lat", lat)
                .queryParam("lng", lng)
                .queryParam("maxDistanceKM", maxDistanceKM);

        return abstractExternalAPIService.get(builder);
    }

    @GetMapping("point")
    public ResponseEntity getDetailedMeasurementPointEndpoint(@RequestParam("indexType") String indexType,
                                                              @RequestParam("lat") double lat,
                                                              @RequestParam("lng") double lng) throws JsonParseException {
        String url = "https://airapi.airly.eu/v2/measurements/point";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("indexType", indexType)
                .queryParam("lat", lat)
                .queryParam("lng", lng);

        return abstractExternalAPIService.get(builder);
    }
}

