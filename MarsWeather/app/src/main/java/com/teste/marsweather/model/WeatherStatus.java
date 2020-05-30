package com.teste.marsweather.model;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class WeatherStatus {


    /* With Map
    public static final String air_temperature = "temperature";
    public static final String air_pressure = "pressure";
    public static final String air_average = "average";
    public static final String air_minimum = "minimum";
    public static final String air_maximum = "maximum";

    private String season;
    @SerializedName("air")
    private Map<String,Map<String,Float>> airMap = new HashMap<>();

    public WeatherStatus() {
    }

    public WeatherStatus(String season, Map<String, Map<String, Float>> airMap) {
        this.season = season;
        this.airMap = airMap;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Map<String, Map<String, Float>> getAirMap() {
        return airMap;
    }

    public void setAirMap(Map<String, Map<String, Float>> airMap) {
        this.airMap = airMap;
    }*/

    private String season;
    private Air air;

    public WeatherStatus() {
    }

    public WeatherStatus(String season, Air air) {
        this.season = season;
        this.air = air;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Air getAir() {
        return air;
    }

    public void setAir(Air air) {
        this.air = air;
    }

    public static class Air{
        private Temperature temperature;

        public Air(Temperature temperature) {
            this.temperature = temperature;
        }

        public Temperature getTemperature() {
            return temperature;
        }

        public void setTemperature(Temperature temperature) {
            this.temperature = temperature;
        }
    }

    public static class Temperature{

        private float average;
        private float minimum;
        private float maximum;

        public Temperature(float average, float minimum, float maximum) {
            this.average = average;
            this.minimum = minimum;
            this.maximum = maximum;
        }

        public float getAverage() {
            return average;
        }

        public void setAverage(float average) {
            this.average = average;
        }

        public float getMinimum() {
            return minimum;
        }

        public void setMinimum(float minimum) {
            this.minimum = minimum;
        }

        public float getMaximum() {
            return maximum;
        }

        public void setMaximum(float maximum) {
            this.maximum = maximum;
        }
    }
}
