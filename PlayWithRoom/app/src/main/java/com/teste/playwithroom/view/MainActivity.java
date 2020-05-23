package com.teste.playwithroom.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.teste.playwithroom.R;
import com.teste.playwithroom.adapters.PlayGamesAdapter;
import com.teste.playwithroom.database.DatabaseConnection;
import com.teste.playwithroom.database.PlayGameDao_Impl;
import com.teste.playwithroom.databinding.ActivityMainBinding;
import com.teste.playwithroom.model.PlayGame;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private List<PlayGame> gameList;
    private DatabaseConnection connection;
    private PlayGamesAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        gameList = new ArrayList<>();
        connection = DatabaseConnection.getInstance(this);
        adapter = new PlayGamesAdapter(gameList);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayGame playGame = new PlayGame("Amarelinha",10,"Pular amarelinha");
                connection.playGameDao().insert(playGame);
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameList.clear();
                gameList.addAll(connection.playGameDao().getAllGames());
                binding.recyclerView.scrollToPosition(adapter.getItemCount() - 1);
                adapter.notifyDataSetChanged();
            }
        });

        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!gameList.isEmpty()){
                    connection.playGameDao().delete((gameList.size() - 1));
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}
