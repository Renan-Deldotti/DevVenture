package com.teste.canilroomviewmodel.database;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"weight","height","bred_for","breed_group","life_span","temperament","origin","country_code","description","history"})
public class DogNameId {
    private String id;
    private String name;

    public DogNameId() {
    }

    public DogNameId(String id, String name) {
        this.id = id;
        this.name = name;
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
}
