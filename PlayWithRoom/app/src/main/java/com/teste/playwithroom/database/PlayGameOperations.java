package com.teste.playwithroom.database;

import android.content.Context;
import android.os.AsyncTask;

import com.teste.playwithroom.model.PlayGame;

import java.util.List;

public class PlayGameOperations {

    private DatabaseConnection connection;
    private Context context;
    private List<PlayGame> gameList;

    public PlayGameOperations(Context context){
        this.context = context;
        connection = DatabaseConnection.getInstance(context);
        new GetAllGamesTask().execute();
    }

    public void insertPlayGame(PlayGame game){
        connection = DatabaseConnection.getInstance(context);
        new InsertGameTask().execute(game);
    }

    public List<PlayGame> getAllGames(){
        new GetAllGamesTask().execute();
        return gameList;
    }

    public void deleteLastItem(PlayGame game){
        new DeleteGameTask().execute(game);
    }

    private class InsertGameTask extends AsyncTask<PlayGame, Void, Void>{

        @Override
        protected Void doInBackground(PlayGame... playGames) {
            connection.playGameDao().insert(playGames[0]);
            return null;
        }
    }

    private class GetAllGamesTask extends AsyncTask<Void,Void,List<PlayGame>>{
        @Override
        protected List<PlayGame> doInBackground(Void... voids) {
            return connection.playGameDao().getAllGames();
        }

        @Override
        protected void onPostExecute(List<PlayGame> playGames) {
            gameList = playGames;
        }
    }

    private class DeleteGameTask extends AsyncTask<PlayGame, Void, Void>{
        @Override
        protected Void doInBackground(PlayGame... playGames) {
            connection.playGameDao().delete(playGames[0]);
            return null;
        }
    }
}
