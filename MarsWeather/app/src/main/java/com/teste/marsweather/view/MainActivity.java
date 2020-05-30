package com.teste.marsweather.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.teste.marsweather.R;
import com.teste.marsweather.databinding.ActivityMainBinding;
import com.teste.marsweather.model.MarsPhoto;
import com.teste.marsweather.model.WeatherStatus;
import com.teste.marsweather.model.WeatherStatusViewModel;
import com.teste.marsweather.retrofit.MarsWeatherAPI;
import com.teste.marsweather.retrofit.RetrofitConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
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
    private void receivePhoto(){
        viewModel.photoUrl.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                setImageView(s);
            }
        });
    }

    private void setImageView(String photoUrl) {
        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_camera);
        Glide.with(getApplicationContext())
                .setDefaultRequestOptions(requestOptions)
                .load(photoUrl)
                .into(binding.imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.getPhotos) {
            viewModel.getMarsPhoto();
            receivePhoto();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
