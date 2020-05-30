package com.teste.marsweather.retrofit;

import androidx.annotation.RestrictTo;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig{

    private final Retrofit retrofit;
    private static final String baseUrl = "https://api.mars.spacexcompanion.app/v1/";
    private MarsWeatherAPI marsWeatherAPI;

    public  RetrofitConfig(){
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    public MarsWeatherAPI getMarsWeatherAPI() {
        marsWeatherAPI = retrofit.create(MarsWeatherAPI.class);
        return marsWeatherAPI;
    }
}
