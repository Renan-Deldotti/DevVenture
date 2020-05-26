package com.teste.playwithretrofit.retrofit;

import com.teste.playwithretrofit.model.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonAPI {

    @GET("pokemon/{id}")
    Call<Pokemon> getPokemonById(@Path("id") int id);
}
