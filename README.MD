# weatherCheckApp - simple app
> A terminal-based client of Airly API (https://map.airly.eu/)!

## Table of contents
* [General info](#general-info)
* [Screenshots](#screenshots)
* [Technologies](#technologies)
* [Setup](#setup)
* [Features](#features)
* [Status](#status)
* [Inspiration](#inspiration)
* [Contact](#contact)

## General info
This app applies to API version 2.0.

## 
![Example screenshot](./screenshot.png)

## Technologies
* Tech 1 - version 1.0
* Tech 2 - version 2.0
* Tech 3 - version 3.0

## Code Examples
Show examples of usage:
`@GET("v2/installations/nearest")
    Call<Installation> nearestInstallations(@Header("2zdLEMfQrhyHB0q8fL4Gly3uAOt9Lutx") String apiKey,
                                            @Query("lat") double latitude,
                                            @Query("lng") double longitude,
                                            @Query("maxDistanceKM") double maxDistanceKm,
                                            @Query("maxResults") int maxResults);


    @GET("v2/installations/{installationId}")
    Call<Installation> installation(@Header("2zdLEMfQrhyHB0q8fL4Gly3uAOt9Lutx") String apiKey,
                                    @Path("installationId") int installationId);

    @GET("v2/measurements/installation")
    Call<Measurement> measurements(@Header("2zdLEMfQrhyHB0q8fL4Gly3uAOt9Lutx") String apiKey,
                                   @Query("installationId") int installationId);

    @GET("v2/measurements/nearest")
    Call<Measurement> nearestMeasurements(@Header("2zdLEMfQrhyHB0q8fL4Gly3uAOt9Lutx") String apiKey,
                                          @Query("lat") double latitude,
                                          @Query("lng") double longitude,
                                          @Query("maxDistanceKM") double maxDistanceKm);

    @GET("v2/measurements/point")
    Call<Measurement> interpolatedMeasurements(@Header("2zdLEMfQrhyHB0q8fL4Gly3uAOt9Lutx") String apiKey,
                                               @Query("lat") double latitude,
                                               @Query("lng") double longitude);

`

## Features
List of features ready and TODOs for future development
* Awesome feature 1
* Awesome feature 2
* Awesome feature 3

To-do list:
* Wow improvement to be done 1
* Wow improvement to be done 2

## Status
Project is: _in progress_ :)

## Inspiration
Add here credits. Project inspired by..., based on...

## Contact
Created by [@Agula2018] - feel free to contact me!
