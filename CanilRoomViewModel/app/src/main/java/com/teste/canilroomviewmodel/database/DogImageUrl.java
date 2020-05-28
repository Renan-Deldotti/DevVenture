package com.teste.canilroomviewmodel.database;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"breeds","weight","height","id","name","bred_for","life_span","temperament","origin","width","height"})
public class DogImageUrl {
    private String url;

    public DogImageUrl(){}

    public DogImageUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
