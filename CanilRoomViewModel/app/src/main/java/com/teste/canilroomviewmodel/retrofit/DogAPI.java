package com.teste.canilroomviewmodel.retrofit;

import androidx.cardview.widget.CardView;

import com.teste.canilroomviewmodel.database.Dog;
import com.teste.canilroomviewmodel.database.DogNameId;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DogAPI {

    @GET("breeds/{id}")
    Call<Dog> getDogById(@Path("id") int id);

    @GET("breeds")
    Call<List<DogNameId>> getAllBreeds();
}
