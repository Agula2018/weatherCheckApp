package com.agnieszka.piotrowska.weatherCheckApp.service;

import org.springframework.stereotype.Service;

@Service
public class URLBuilder {

    StringBuilder stringBuilder = new StringBuilder();
    String url = "https://airapi.airly.eu/";
    String urlAppendInstallation = stringBuilder.append(url).append("installations/").toString();

}
