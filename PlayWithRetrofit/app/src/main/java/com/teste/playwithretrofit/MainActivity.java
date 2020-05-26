package com.teste.playwithretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.teste.playwithretrofit.databinding.ActivityMainBinding;
import com.teste.playwithretrofit.model.Pokemon;
import com.teste.playwithretrofit.retrofit.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private RetrofitConfig retrofitConfig;
    private Call<Pokemon> request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        retrofitConfig = new RetrofitConfig();

        binding.buttonRequest.setOnClickListener(v -> {
            request = retrofitConfig.getPokemonAPI().getPokemonById(Integer.parseInt(binding.editText.getText().toString().trim()));
            request.enqueue(new Callback<Pokemon>() {
                @Override
                public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                    Pokemon pokemon = response.body();
                    if (pokemon != null) {
                        binding.textViewId.setText(String.valueOf(pokemon.getId()));
                        binding.textViewName.setText(pokemon.getName());
                        binding.textViewHeight.setText(String.valueOf(pokemon.getHeight()));
                        binding.textViewWeight.setText(String.valueOf(pokemon.getWeight()));
                    }
                }

                @Override
                public void onFailure(Call<Pokemon> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Failed to get Pokemon", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
