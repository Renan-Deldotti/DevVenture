package com.teste.playwithroom.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.teste.playwithroom.model.PlayGame;

import java.util.List;

@Dao
public interface PlayGameDao {

    @Insert
    void insert(PlayGame game);

    @Delete
    void delete(PlayGame game);

    @Query("SELECT * FROM PlayGame")
    List<PlayGame> getAllGames();

    @Query("SELECT * FROM PlayGame WHERE id=:id")
    PlayGame getById(int id);

    @Query("DELETE FROM PlayGame WHERE id=:id")
    void deleteId(int id);
}
