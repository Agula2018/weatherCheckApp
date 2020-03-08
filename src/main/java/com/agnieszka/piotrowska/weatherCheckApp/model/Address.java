package com.agnieszka.piotrowska.weatherCheckApp.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties
@Data
public class Address {


        private String country;
        private String city;
        private String street;
        private String number;
        private String displayAddress1;
        private String displayAddress2;


}
