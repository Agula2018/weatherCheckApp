package com.agnieszka.piotrowska.weatherCheckApp.requestmapping;

import org.jetbrains.annotations.Nullable;

public class Arguments {

    public final String apiKey;
    public final @Nullable Double latitude;
    public final @Nullable Double longitude;
    public final @Nullable Double maxDistanceKm;
    public final @Nullable Integer maxResults;
    public final @Nullable Integer installationId;

    public Arguments(String apiKey, double latitude, double longitude, double maxDistanceKm, int maxResults) {
        this.apiKey = apiKey;
        this.latitude = latitude;
        this.longitude = longitude;
        this.maxDistanceKm = maxDistanceKm;
        this.maxResults = maxResults;
        this.installationId = null;
    }

    public Arguments(String apiKey, Integer installationId) {
        this.apiKey = apiKey;
        this.latitude = null;
        this.longitude = null;
        this.maxDistanceKm = null;
        this.maxResults = null;
        this.installationId = installationId;
    }

    public Arguments(String apiKey, Double latitude,  Double longitude) {
        this.apiKey = apiKey;
        this.latitude = latitude;
        this.longitude = longitude;
        this.maxDistanceKm = null;
        this.maxResults = null;
        this.installationId = null;
    }

    public Arguments(String apiKey, Double latitude, Double longitude,  Double maxDistanceKm) {
        this.apiKey = apiKey;
        this.latitude = latitude;
        this.longitude = longitude;
        this.maxDistanceKm = maxDistanceKm;
        this.maxResults = null;
        this.installationId = null;
    }
}
