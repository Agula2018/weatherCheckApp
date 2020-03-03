# weatherCheckApp - simple app
> Console client for Airly API (https://map.airly.eu/)!

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Features](#features)
* [Status](#status)
* [Inspiration](#inspiration)
* [Contact](#contact)

## General info
This app applies to Airly API version 2.0.

## 
![Example screenshot](./screenshot.png)

## Technologies
* JAVA - version 11
* Spring Boot - version 2.5.0
* Hibernate - version 6.0.16


## Code Examples
Show examples of usage:
```
{

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
```

## Features
List of features ready and TODOs for future development
* TEST 



To-do list:
* make a data base 

## Status
Project is: 
_in progress_ :)

## Inspiration
Project inspired by FairIT. 

## Contact
Created by [@Agula2018] - feel free to contact me!
