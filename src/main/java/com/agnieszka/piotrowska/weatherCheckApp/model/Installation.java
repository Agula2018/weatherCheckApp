package com.agnieszka.piotrowska.weatherCheckApp.model;

import lombok.Data;

@Data
public class Installation {

    private int installationId;
    private Location location;
    private Addresses address;
    private double elevation;
    private Sponsor sponsor;
    private boolean airly;

    public static class Location {

        private double latitude;
        private double longitude;

    }

    public static class Addresses {

        private String country;
        private String city;
        private String street;
        private String number;
    }

    public static class Sponsor {

        private String name;
        private String description;
        private String logo;
        private String link;
    }
}
