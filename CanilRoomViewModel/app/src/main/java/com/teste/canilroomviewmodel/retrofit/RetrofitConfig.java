package com.teste.canilroomviewmodel.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    public static final String BASE_URL = "https://api.thedogapi.com/v1/";
    private final Retrofit getRetrofit;
    private DogAPI dogAPI;

    public RetrofitConfig(){
        getRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public DogAPI getDogAPI() {
        return getRetrofit.create(DogAPI.class);
    }
}
