package com.teste.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> stringList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateList();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter();
        recyclerView.setAdapter(recyclerAdapter);
    }

    private void populateList(){
        for (int i = 0; i < 20;i++){
            stringList.add("Aluno "+i);
        }
        Log.e(MainActivity.class.getSimpleName(), stringList.toString());
    }
}
