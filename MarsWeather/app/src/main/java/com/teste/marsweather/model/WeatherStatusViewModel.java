package com.teste.marsweather.model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.teste.marsweather.retrofit.RetrofitConfig;

import java.util.Random;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class WeatherStatusViewModel extends ViewModel {

    private static final String TAG = WeatherStatusViewModel.class.getSimpleName();
    public MutableLiveData<WeatherStatus> weatherStatusMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<MarsPhoto> marsPhotoMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<String> photoUrl = new MutableLiveData<>();
    private RetrofitConfig retrofitConfigWeather = new RetrofitConfig();
    private RetrofitConfig retrofitConfigPhoto = new RetrofitConfig(true);

    public void getLatestWeather() {
        retrofitConfigWeather.getMarsWeatherAPI().getLatestWeatherStatus()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<WeatherStatus, WeatherStatus>() {
                    @Override
                    public WeatherStatus apply(WeatherStatus weatherStatus) throws Throwable {
                        weatherStatus.setSeason(weatherStatus.getSeason().toUpperCase());
                        return weatherStatus;
                    }
                })
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

    public void getMarsPhoto(){
        //marsPhotoMutableLiveData = retrofitConfigPhoto.getMarsWeatherAPI().getLatestPhotos();
        retrofitConfigPhoto.getMarsWeatherAPI().getLatestPhotosWithoutCamera("2020-5-29")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MarsPhoto>() {
                    @Override
                    public void accept(MarsPhoto marsPhoto) throws Throwable {
                        String url = marsPhoto.getPhotos().get(0).getImg_src();
                        photoUrl.postValue(url);
                    }
                });
    }
}
