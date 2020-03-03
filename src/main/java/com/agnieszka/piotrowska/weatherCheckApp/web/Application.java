package com.agnieszka.piotrowska.weatherCheckApp.web;

import com.agnieszka.piotrowska.weatherCheckApp.model.LocatedMeasurement;
import com.agnieszka.piotrowska.weatherCheckApp.requestmapping.Arguments;
import com.agnieszka.piotrowska.weatherCheckApp.service.AirlyService;
import retrofit2.Call;
import retrofit2.Response;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {

    }

    Arguments arguments;

    //GET DATA FROM SERVER
    Call<LocatedMeasurement> call = prepareCall(arguments);
    Response<LocatedMeasurement> response;
    {
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the server" + e.getMessage());
        }catch (Exception e){
            System.out.println("An unexpected error occurred during creating the request or decoding the response");
        }
    }


    LocatedMeasurement measurements = response.body();


    private static Call<LocatedMeasurement> prepareCall(Arguments arguments) {
        AirlyService api = new AirlyRetrofitClient().createAirlyApi();

        if (arguments.latitude != null && arguments.longitude != null){
            return api.nearestInstallations(arguments.apiKey, arguments.latitude, arguments.longitude, arguments.maxDistanceKm, arguments.maxResults);

        }else if (arguments.installationId != null){
            return api.installation(arguments.apiKey, arguments.installationId);

        }else if (arguments.installationId != null){
            return api.measurements(arguments.apiKey, arguments.installationId);

        }else if (arguments.latitude != null && arguments.longitude != null){
            return api.nearestMeasurements(arguments.apiKey, arguments.latitude, arguments.longitude, arguments.maxDistanceKm);

        }else {
            return api.interpolatedMeasurements(arguments.apiKey, arguments.latitude, arguments.longitude);
        }
    }
}
