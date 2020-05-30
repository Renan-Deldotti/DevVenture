package com.teste.marsweather.dependecyInjection;

import com.teste.marsweather.model.WeatherStatusViewModel;

import dagger.Component;

@Component(modules = {RetrofitPhotoModule.class, RetrofitWeatherModule.class})
public interface RetrofitPhotoComponent {
    void inject(WeatherStatusViewModel weatherStatusViewModel);
}
