package com.teste.canilroomviewmodel.database;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

//@JsonIgnoreProperties({"id"})
public class Dog {

    private String id;
    private String name;
    private String bred_for;
    private String breed_group;
    private String life_span;
    private String temperament;
    private List<String> weight;
    private List<String> height;

    public Dog() {
    }

    public Dog(String id, String name, String bred_for, String breed_group, String life_span, String temperament, List<String> weight, List<String> height) {
        this.id = id;
        this.name = name;
        this.bred_for = bred_for;
        this.breed_group = breed_group;
        this.life_span = life_span;
        this.temperament = temperament;
        this.weight = weight;
        this.height = height;
    }

    public String getId() {
        return id;
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

    public List<String> getWeight() {
        return weight;
    }

    public void setWeight(List<String> weight) {
        this.weight = weight;
    }

    public List<String> getHeight() {
        return height;
    }

    public void setHeight(List<String> height) {
        this.height = height;
    }
}
