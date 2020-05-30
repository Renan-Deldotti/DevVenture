package com.teste.marsweather.model;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.teste.marsweather.retrofit.RetrofitConfig;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class WeatherStatusViewModel extends ViewModel {

    private static final String TAG = WeatherStatusViewModel.class.getSimpleName();
    public MutableLiveData<WeatherStatus> weatherStatusMutableLiveData = new MutableLiveData<>();
    private RetrofitConfig retrofitConfig = new RetrofitConfig();

    public void getLatestWeather() {
        retrofitConfig.getMarsWeatherAPI().getLatestWeatherStatus()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherStatus>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {
                        Log.e(TAG, "Subscribed.");
                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull WeatherStatus weatherStatus) {
                        //String temperature = String.valueOf(weatherStatus.getAirMap().get(WeatherStatus.air_temperature).get(WeatherStatus.air_average));
                        //String season = weatherStatus.getSeason();
                        weatherStatusMutableLiveData.postValue(weatherStatus);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        Log.e(TAG, "" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "Completed.");

                    }
                });
    }
}
