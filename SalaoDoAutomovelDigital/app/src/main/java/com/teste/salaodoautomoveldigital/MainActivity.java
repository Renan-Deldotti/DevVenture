package com.teste.salaodoautomoveldigital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        CarListAdapter adapter = new CarListAdapter(populateCarList(),MainActivity.this);
        recyclerView.setAdapter(adapter);
    }

    private List<Car> populateCarList() {
        List<Car> carList = new ArrayList<>();

        Bitmap camaro = BitmapFactory.decodeResource(getResources(), R.drawable.chevrolet_camaro_z28_1973);
        Bitmap chevelle = BitmapFactory.decodeResource(getResources(), R.drawable.chevrolet_chevelle_ss);
        Bitmap dodgeCharger = BitmapFactory.decodeResource(getResources(), R.drawable.dodge_charger_1969);
        Bitmap hemiCuda = BitmapFactory.decodeResource(getResources(), R.drawable.plymouth_hemi_cuda);
        Bitmap firebirdFormula = BitmapFactory.decodeResource(getResources(), R.drawable.pontiac_firebird_formula_1974);
        Bitmap shelbyCobra = BitmapFactory.decodeResource(getResources(), R.drawable.shelby_cobra);
        Bitmap shelbyMustang = BitmapFactory.decodeResource(getResources(), R.drawable.shelby_mustang_gt500_1967);


        carList.add(new Car(camaro,"Chevrolet Camaro Z28","290hp","1973"));
        carList.add(new Car(chevelle,"Chevrolet Chevelle SS","450hp","1970"));
        carList.add(new Car(dodgeCharger,"DODGE Charger","425hp","1969"));
        carList.add(new Car(hemiCuda,"Plymouth Hemi Cuda","428hp","1970"));
        carList.add(new Car(firebirdFormula,"Pontiac firebird Formula","400hp","1974"));
        carList.add(new Car(shelbyCobra,"Shelby Cobra","450hp","1966"));
        carList.add(new Car(shelbyMustang,"Shelby Mustang GT500","335hp","1967"));

        return carList;
    }
}
