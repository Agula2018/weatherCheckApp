package com.agnieszka.piotrowska.weatherCheckApp.web;

import com.agnieszka.piotrowska.weatherCheckApp.service.AirlyService;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class AirlyRetrofitClient {

    public AirlyService createAirlyApi() {
        OkHttpClient httpClient = new OkHttpClient();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://airapi.airly.eu/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
        return retrofit.create(AirlyService.class);
    }
}

