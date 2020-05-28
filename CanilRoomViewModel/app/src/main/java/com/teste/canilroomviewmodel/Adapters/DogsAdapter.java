package com.teste.canilroomviewmodel.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.teste.canilroomviewmodel.R;
import com.teste.canilroomviewmodel.database.Dog;
import com.teste.canilroomviewmodel.database.DogNameId;
import com.teste.canilroomviewmodel.view.DogsListFragmentDirections;

import java.util.List;

public class DogsAdapter extends RecyclerView.Adapter<DogsAdapter.DogsViewHolder> {

    private List<DogNameId> dogList;

    public DogsAdapter(List<DogNameId> dogList){
        this.dogList = dogList;
    }

    @NonNull
    @Override
    public DogsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_dog_list,parent,false);
        return new DogsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogsViewHolder holder, int position) {
        holder.textViewBreed.setText(dogList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return dogList.size();
    }

    class DogsViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewBreed;
        public DogsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewBreed = itemView.findViewById(R.id.textView_dogBreed);

            itemView.setOnClickListener(v -> {
                NavDirections directions = DogsListFragmentDirections.actionDogsListFragmentToDogDetailsFragment(dogList.get(getAdapterPosition()).getId());
                Navigation.findNavController(v).navigate(directions);
            });
        }
    }
}
