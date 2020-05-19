package com.teste.digitalzoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(new AnimalListAdapter(populateAnimalsList()));
    }

    private List<Animal> populateAnimalsList(){
        List<Animal> animalList = new ArrayList<>();

        Animal animal1 = new Animal(0,10,R.drawable.animal1,"Suricato","Mamífero");

        animalList.add(animal1);
        animalList.add(new Animal(1,12,R.drawable.animal2,"Cachorro","Canino"));
        animalList.add(new Animal(2,40,R.drawable.animal3,"Girafa","Herbivora"));
        animalList.add(new Animal(3,15,R.drawable.animal4,"Tigre","Carnivoro"));
        animalList.add(new Animal(4,30,R.drawable.animal5,"Macaco","Herbivoro"));

        return animalList;
    }
}
