package com.teste.marsweather.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.teste.marsweather.R;
import com.teste.marsweather.databinding.ActivityMainBinding;
import com.teste.marsweather.model.WeatherStatus;
import com.teste.marsweather.model.WeatherStatusViewModel;
import com.teste.marsweather.retrofit.MarsWeatherAPI;
import com.teste.marsweather.retrofit.RetrofitConfig;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView textViewSeason, textViewTemperature;
    private WeatherStatusViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(WeatherStatusViewModel.class);
        viewModel.getLatestWeather();
        receiveWeatherStatus();
    }

    private void receiveWeatherStatus(){
        viewModel.weatherStatusMutableLiveData.observe(this, weatherStatus -> binding.setWeatherStatus(weatherStatus));
    }
}
