package com.teste.canilroomviewmodel.view;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.teste.canilroomviewmodel.R;
import com.teste.canilroomviewmodel.database.Dog;
import com.teste.canilroomviewmodel.databinding.FragmentDogDetailsBinding;
import com.teste.canilroomviewmodel.retrofit.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DogDetailsFragment extends Fragment {

    private static final String TAG = DogDetailsFragment.class.getSimpleName();
    private FragmentDogDetailsBinding binding;
    private RetrofitConfig retrofitConfig;
    private Call<Dog> dogCall;
    private String idToSearch;

    public DogDetailsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idToSearch = DogDetailsFragmentArgs.fromBundle(getArguments()).getDogId();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDogDetailsBinding.inflate(getLayoutInflater(), container, false);
        View rootView = binding.getRoot();

        retrofitConfig = new RetrofitConfig();

        if (getActivity() != null && getContext() != null) {
            if (PermissionChecker.checkSelfPermission(getContext(), Manifest.permission.INTERNET) != PermissionChecker.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.INTERNET}, 1);
            } else {
                startAPI();
            }
        }

        return rootView;
    }

    private void startAPI() {
        dogCall = retrofitConfig.getDogAPI().getDogById(Integer.parseInt(idToSearch));
        dogCall.enqueue(new Callback<Dog>() {
            @Override
            public void onResponse(Call<Dog> call, Response<Dog> response) {
                Dog dogById = response.body();
                if (dogById != null) {
                    binding.dogDetailsTextViewDogName.setText(dogById.getName());
                    binding.dogDetailsTextViewDogCountryCode.setText(dogById.getCountry_code());
                    binding.dogDetailsTextViewDogLifeSpan.setText(dogById.getLife_span());
                    binding.dogDetailsTextViewDogWeight.setText(String.valueOf(dogById.getWeight().get(Dog.MeasureInMetric)));
                    binding.dogDetailsTextViewDogHeight.setText(String.valueOf(dogById.getHeight().get(Dog.MeasureInMetric)));
                    binding.dogDetailsTextViewDogBreedGroup.setText(dogById.getBreed_group());
                }
                Log.e(TAG, "Response code: " + response.code());
            }

            @Override
            public void onFailure(Call<Dog> call, Throwable t) {
                Log.e(TAG, "Failed to retrieve info from API\n" + t.getMessage());
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startAPI();
            } else {
                Toast.makeText(getContext(), "Internet permission not granted", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
