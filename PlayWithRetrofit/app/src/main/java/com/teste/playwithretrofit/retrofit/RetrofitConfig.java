package com.teste.playwithretrofit.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private static final String baseUrl ="https://pokeapi.co/api/v2/";

    private final Retrofit config;
    private PokemonAPI pokemonAPI;

    public RetrofitConfig() {
        config = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public PokemonAPI getPokemonAPI() {
        return config.create(PokemonAPI.class);
    }
}
