package com.teste.marsweather.retrofit;

import com.teste.marsweather.model.MarsPhoto;

import java.net.URI;

import javax.inject.Inject;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    /*public Retrofit retrofit;
    private static final String weatherbaseUrl = "https://api.mars.spacexcompanion.app/v1/";
    private static final String basePhotosUrl = "https://mars-photos.herokuapp.com/api/v1/";
    private MarsWeatherAPI marsWeatherAPI;
    private MarsPhoto marsPhoto;

    public RetrofitConfig() {
        retrofit = new Retrofit.Builder()
                .baseUrl(weatherbaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    public RetrofitConfig(boolean isPhoto) {
        retrofit = new Retrofit.Builder()
                .baseUrl(basePhotosUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    public MarsWeatherAPI getMarsWeatherAPI() {
        //marsWeatherAPI = retrofit.create(MarsWeatherAPI.class);
        return marsWeatherAPI;
    }*/
}
