package com.teste.marsweather.retrofit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.teste.marsweather.model.MarsPhoto;
import com.teste.marsweather.model.WeatherStatus;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MarsWeatherAPI {
    @GET("weather/latest")
    Observable<WeatherStatus> getLatestWeatherStatus();
}
