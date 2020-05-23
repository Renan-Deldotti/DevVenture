package com.teste.playwithroom.model;

public class PlayGame {

    private Integer id;
    private String name;
    private Integer players;
    private String description;

    public PlayGame(Integer id, String name, Integer players, String description) {
        this.id = id;
        this.name = name;
        this.players = players;
        this.description = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPlayers() {
        return players;
    }

    public String getDescription() {
        return description;
    }
}
