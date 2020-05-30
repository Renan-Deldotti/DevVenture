package com.teste.marsweather.dependecyInjection;

import com.teste.marsweather.retrofit.MarsWeatherAPI;

import dagger.Module;
import dagger.Provides;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitWeatherModule {

    private static final String weatherBaseUrl = "https://api.mars.spacexcompanion.app/v1/";

    @Provides
    public MarsWeatherAPI getRetrofitWeatherConfig() {
        return new Retrofit.Builder()
                .baseUrl(weatherBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(MarsWeatherAPI.class);
    }
}
