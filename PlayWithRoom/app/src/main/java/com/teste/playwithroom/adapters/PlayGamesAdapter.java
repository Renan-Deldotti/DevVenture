package com.teste.playwithroom.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.teste.playwithroom.R;
import com.teste.playwithroom.model.PlayGame;

import java.util.List;

public class PlayGamesAdapter extends RecyclerView.Adapter<PlayGamesAdapter.PlayGamesViewHolder> {

    List<PlayGame> playGameList;

    public PlayGamesAdapter(List<PlayGame> playGames){
        playGameList = playGames;
    }

    @NonNull
    @Override
    public PlayGamesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.playgames_item,parent,false);
        return new PlayGamesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayGamesViewHolder holder, int position) {
        PlayGame thisGame = playGameList.get(position);
        holder.id.setText(String.valueOf(thisGame.getId()));
        holder.name.setText(thisGame.getName());
        holder.description.setText(thisGame.getDescription());
        holder.player.setText(String.valueOf(thisGame.getPlayers()));
    }

    @Override
    public int getItemCount() {
        return playGameList.size();
    }

    static class PlayGamesViewHolder extends RecyclerView.ViewHolder{

        TextView id, name, description, player;

        PlayGamesViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textView2);
            name = itemView.findViewById(R.id.textView);
            description = itemView.findViewById(R.id.textView3);
            player = itemView.findViewById(R.id.textView4);
        }
    }
}
