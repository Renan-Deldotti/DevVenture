package com.teste.marsweather.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.teste.marsweather.R;
import com.teste.marsweather.model.WeatherStatus;
import com.teste.marsweather.retrofit.RetrofitConfig;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RetrofitConfig retrofit;
    private TextView textViewSeason, textViewTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit =new RetrofitConfig();

        textViewTemperature = findViewById(R.id.textView_tempAvarage);
        textViewSeason = findViewById(R.id.textView_season);

        retrofit.getMarsWeatherAPI().getLatestWeatherStatus()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherStatus>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG,"Subscribed.");
            }

            @Override
            public void onNext(@NonNull WeatherStatus weatherStatus) {
                //String temperature = String.valueOf(weatherStatus.getAirMap().get(WeatherStatus.air_temperature).get(WeatherStatus.air_average));
                //String season = weatherStatus.getSeason();

                String temperature = String.valueOf(weatherStatus.getAir().getTemperature().getAverage());
                String season = weatherStatus.getSeason();

                textViewTemperature.setText(temperature);
                textViewSeason.setText(season);

                Log.e(TAG, temperature);
                Log.e(TAG, season);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG,""+e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"Completed.");

            }
        });
    }
}
