package com.agnieszka.piotrowska.weatherCheckApp.model;

import lombok.Data;

import java.util.List;
@Data
public class SingleMeasurement {

    private String fromDateTime;
    private String tillDateTime;
    private List <Value> valueList;
    private List <Index> indexList;
    private List <Standard> standardList;

    public static class Value {
        private String name;
        private double value;
    }

    public static class Standard {

        private String name;
        private String pollutant;
        private double limit;
        private double percent;

    }

    public static class Index {

        private String name;
        private double value;
        private String level;
        private String description;
        private String advice;
        private String color;

    }
}
