package com.teste.marsweather.retrofit;

import com.teste.marsweather.model.WeatherStatus;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface MarsWeatherAPI {
    @GET("weather/latest")
    Observable<WeatherStatus> getLatestWeatherStatus();
}
