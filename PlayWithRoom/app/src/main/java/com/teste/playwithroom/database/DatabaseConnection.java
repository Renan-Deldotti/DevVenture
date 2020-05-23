package com.teste.playwithroom.database;

import android.content.Context;
import android.provider.ContactsContract;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.teste.playwithroom.model.PlayGame;

@Database(entities = {PlayGame.class}, version = 1, exportSchema = false)
public abstract class DatabaseConnection extends RoomDatabase {

    private static DatabaseConnection instance;

    public abstract PlayGameDao playGameDao();

    public static DatabaseConnection getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),DatabaseConnection.class,"playgames_database")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }


}
