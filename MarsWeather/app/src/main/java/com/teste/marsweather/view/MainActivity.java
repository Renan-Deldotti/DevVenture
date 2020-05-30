package com.teste.marsweather.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.teste.marsweather.R;
import com.teste.marsweather.databinding.ActivityMainBinding;
import com.teste.marsweather.model.WeatherStatusViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private WeatherStatusViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(WeatherStatusViewModel.class);
        viewModel.getLatestWeather();
        receiveWeatherStatus();
    }

    private void receiveWeatherStatus() {
        viewModel.weatherStatusMutableLiveData.observe(this, weatherStatus -> binding.setWeatherStatus(weatherStatus));
    }

    private void receivePhoto() {
        viewModel.photoUrl.observe(this, s -> binding.setMarsPhoto(s));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
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
