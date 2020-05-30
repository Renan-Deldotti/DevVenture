package com.teste.marsweather.model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.teste.marsweather.dependecyInjection.DaggerRetrofitPhotoComponent;
import com.teste.marsweather.retrofit.MarsWeatherAPI;
import com.teste.marsweather.retrofit.PhotoApi;

import java.util.Random;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class WeatherStatusViewModel extends ViewModel {

    private static final String TAG = WeatherStatusViewModel.class.getSimpleName();
    public MutableLiveData<WeatherStatus> weatherStatusMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<String> photoUrl = new MutableLiveData<>();

    @Inject
    MarsWeatherAPI marsWeatherAPI;

    @Inject
    PhotoApi photoApi;

    public WeatherStatusViewModel() {
        DaggerRetrofitPhotoComponent.create().inject(this);
    }

    public String mUrl = "";

    public void getLatestWeather() {
        marsWeatherAPI.getLatestWeatherStatus()
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

    public void getMarsPhoto() {
        photoApi.getLatestPhotosWithoutCamera("2020-5-29")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MarsPhoto>() {
                    @Override
                    public void accept(MarsPhoto marsPhoto) throws Throwable {
                        Log.e(TAG, "Number of photos :" + marsPhoto.getPhotos().size());

                        int imageToSearch = new Random().nextInt(30);
                        Log.e(TAG, "Image id to find: " + imageToSearch);

                        String url = marsPhoto.getPhotos().get(imageToSearch).getImg_src();
                        Log.e(TAG, "This photo url: " + url);
                        mUrl = url;
                        photoUrl.postValue(url);
                    }
                });
    }
}
