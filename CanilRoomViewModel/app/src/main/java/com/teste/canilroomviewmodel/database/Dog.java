package com.teste.canilroomviewmodel.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@JsonIgnoreProperties({"history"})
public class Dog implements Serializable {

    @JsonIgnore
    public static final String MeasureInMetric = "metric";
    public static final String MeasureInImperial = "imperial";

    private String id;
    private String name;
    private String bred_for;
    private String breed_group;
    private String origin;
    private String country_code;
    private String description;
    private String life_span;
    private String temperament;
    @JsonProperty("weight")
    private Map<String, Object> weight = new HashMap<>();
    @JsonProperty("height")
    private Map<String, Object> height = new HashMap<>();

    public Dog() {
    }

    public Dog(String id, String name, String bred_for, String breed_group, String origin, String country_code, String description, String life_span, String temperament, Map<String, Object> weight, Map<String, Object> height) {
        this.id = id;
        this.name = name;
        this.bred_for = bred_for;
        this.breed_group = breed_group;
        this.origin = origin;
        this.country_code = country_code;
        this.description = description;
        this.life_span = life_span;
        this.temperament = temperament;
        this.weight = weight;
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBred_for() {
        return bred_for;
    }

    public void setBred_for(String bred_for) {
        this.bred_for = bred_for;
    }

    public String getBreed_group() {
        return breed_group;
    }

    public void setBreed_group(String breed_group) {
        this.breed_group = breed_group;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getLife_span() {
        return life_span;
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public Map<String, Object> getWeight() {
        return weight;
    }

    public void setWeight(Map<String, Object> weight) {
        this.weight = weight;
    }

    public Map<String, Object> getHeight() {
        return height;
    }

    public void setHeight(Map<String, Object> height) {
        this.height = height;
    }
}
