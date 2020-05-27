package com.teste.canilroomviewmodel.retrofit;

import com.teste.canilroomviewmodel.database.Dog;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DogAPI {

    @GET("breeds/{id}")
    Call<Dog> getDogById(@Path("id") int id);
}
