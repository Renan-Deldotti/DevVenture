package com.teste.playwithroom.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PlayGame {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "game_name")
    @NonNull
    private String name;

    @ColumnInfo(name = "number_of_players", defaultValue = "0")
    private Integer players;

    private String description;

    public PlayGame(String name, Integer players, String description) {
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
