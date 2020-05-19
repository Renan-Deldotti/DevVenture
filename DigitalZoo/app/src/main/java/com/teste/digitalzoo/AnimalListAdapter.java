package com.teste.digitalzoo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimalListAdapter extends RecyclerView.Adapter<AnimalListAdapter.AnimalViewHolder> {

    private List<Animal> animalList;

    public AnimalListAdapter(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_item,parent,false);
        return new AnimalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal thisAnimal = animalList.get(position);
        holder.imageView.setImageResource(thisAnimal.getImage());
        holder.textViewName.setText(thisAnimal.getName());
        holder.textViewType.setText(thisAnimal.getType());
        holder.textViewLifeSpan.setText(String.valueOf(thisAnimal.getLifeSpan()));
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    static class AnimalViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textViewName, textViewType, textViewLifeSpan;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.animal_image);
            textViewName = itemView.findViewById(R.id.animal_name);
            textViewType = itemView.findViewById(R.id.animal_type);
            textViewLifeSpan = itemView.findViewById(R.id.animal_lifeSpan);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), textViewName.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
