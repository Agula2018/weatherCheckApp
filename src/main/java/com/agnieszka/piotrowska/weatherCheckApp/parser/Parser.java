package com.agnieszka.piotrowska.weatherCheckApp.parser;

public interface Parser<RESPONSE, DTO> {

    DTO toDto(RESPONSE response);

}
