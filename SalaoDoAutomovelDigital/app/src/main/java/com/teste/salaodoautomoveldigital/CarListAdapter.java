package com.teste.salaodoautomoveldigital;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.CarListHolder> {

    private List<Car> carList;
    private Context mainContext;

    public CarListAdapter(List<Car> carList, Context context) {
        this.carList = carList;
        this.mainContext = context;
    }

    @NonNull
    @Override
    public CarListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_car_list,parent,false);
        return new CarListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CarListHolder holder, int position) {
        Car thisCar = carList.get(position);
        holder.imageViewCar.setImageBitmap(thisCar.getCarPhoto());
        holder.textViewCarName.setText(thisCar.getCarName());
        String string1 = mainContext.getResources().getString(R.string.potencia) + thisCar.getCarPower();
        holder.textViewCarPotencia.setText(string1);
        String string2 = mainContext.getResources().getString(R.string.fabricacao) + thisCar.getCarDate();
        holder.textViewCarFabricacao.setText(string2);
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    class CarListHolder extends RecyclerView.ViewHolder{

        private ImageView imageViewCar;
        private TextView textViewCarName, textViewCarPotencia, textViewCarFabricacao;

        public CarListHolder(@NonNull View itemView) {
            super(itemView);
            imageViewCar = itemView.findViewById(R.id.imageView_car);
            textViewCarName = itemView.findViewById(R.id.textView_carName);
            textViewCarPotencia = itemView.findViewById(R.id.textView_potencia);
            textViewCarFabricacao = itemView.findViewById(R.id.textView_fabricacao);
        }
    }
}
