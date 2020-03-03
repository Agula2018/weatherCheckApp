package com.agnieszka.piotrowska.weatherCheckApp.service;

import com.agnieszka.piotrowska.weatherCheckApp.model.LocatedMeasurement;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AirlyService {

    //Installations
    @GET("v2/installations/nearest")
    Call<LocatedMeasurement> nearestInstallations(@Header("2zdLEMfQrhyHB0q8fL4Gly3uAOt9Lutx") String apiKey,
                                            @Query("lat") double latitude,
                                            @Query("lng") double longitude,
                                            @Query("maxDistanceKM") double maxDistanceKm,
                                            @Query("maxResults") int maxResults);

    //Returns single Installation given by the installationId path parameter
    @GET("v2/installations/{installationId}")
    Call<LocatedMeasurement> installation(@Header("2zdLEMfQrhyHB0q8fL4Gly3uAOt9Lutx") String apiKey,
                                    @Path("installationId") int installationId);

    //Measurements
    @GET("v2/measurements/installation")
    Call<LocatedMeasurement> measurements(@Header("2zdLEMfQrhyHB0q8fL4Gly3uAOt9Lutx") String apiKey,
                                   @Query("installationId") int installationId);

    @GET("v2/measurements/nearest")
    Call<LocatedMeasurement> nearestMeasurements(@Header("2zdLEMfQrhyHB0q8fL4Gly3uAOt9Lutx") String apiKey,
                                          @Query("lat") double latitude,
                                          @Query("lng") double longitude,
                                          @Query("maxDistanceKM") double maxDistanceKm);

    @GET("v2/measurements/point")
    Call<LocatedMeasurement> interpolatedMeasurements(@Header("2zdLEMfQrhyHB0q8fL4Gly3uAOt9Lutx") String apiKey,
                                               @Query("lat") double latitude,
                                               @Query("lng") double longitude);
}