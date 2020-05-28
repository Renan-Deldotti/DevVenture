package com.teste.canilroomviewmodel.retrofit;

import androidx.cardview.widget.CardView;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.teste.canilroomviewmodel.database.Dog;
import com.teste.canilroomviewmodel.database.DogImageUrl;
import com.teste.canilroomviewmodel.database.DogNameId;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DogAPI {

    @GET("breeds/{id}")
    Call<Dog> getDogById(@Path("id") int id);

    @GET("breeds")
    Call<List<DogNameId>> getAllBreeds();

    @GET("images/search?")
    Call<List<DogImageUrl>> getImageUrl(@Query("breed_ids") String id);

}
