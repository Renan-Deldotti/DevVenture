package com.teste.canilroomviewmodel.view;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.teste.canilroomviewmodel.R;
import com.teste.canilroomviewmodel.database.Dog;
import com.teste.canilroomviewmodel.database.DogImageUrl;
import com.teste.canilroomviewmodel.databinding.FragmentDogDetailsBinding;
import com.teste.canilroomviewmodel.retrofit.RetrofitConfig;
import com.teste.canilroomviewmodel.viewModel.DogDetailsViewModel;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DogDetailsFragment extends Fragment {

    private static final String TAG = DogDetailsFragment.class.getSimpleName();
    private FragmentDogDetailsBinding binding;
    private RetrofitConfig retrofitConfig;
    private Call<Dog> dogCall;
    private Dog thisDog;
    private Call<List<DogImageUrl>> dogImageUrlCall;
    private String idToSearch;
    private DogDetailsViewModel dogDetailsViewModel;

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

        if (getActivity() == null){
            return rootView;
        }

        dogDetailsViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(DogDetailsViewModel.class);

        if (getContext() != null) {
            if (PermissionChecker.checkSelfPermission(getContext(), Manifest.permission.INTERNET) != PermissionChecker.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.INTERNET}, 1);
            } else {
                setDataFromAPI();
            }
        }

        return rootView;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setDataFromAPI();
            } else {
                Toast.makeText(getContext(), "Internet permission not granted", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void setDataFromAPI() {
        dogDetailsViewModel.getDogMutableLiveData(idToSearch).observe(getViewLifecycleOwner(), dog -> {
            if (dog != null) {
                binding.dogDetailsTextViewDogName.setText(dog.getName());
                binding.dogDetailsTextViewDogCountryCode.setText((dog.getCountry_code() == null || dog.getCountry_code().isEmpty())?"Not available":dog.getCountry_code());
                binding.dogDetailsTextViewDogLifeSpan.setText(dog.getLife_span());
                binding.dogDetailsTextViewDogWeight.setText(String.valueOf(dog.getWeight().get(Dog.MeasureInMetric)));
                binding.dogDetailsTextViewDogHeight.setText(String.valueOf(dog.getHeight().get(Dog.MeasureInImperial)));
                binding.dogDetailsTextViewDogBreedGroup.setText((dog.getBreed_group() == null || dog.getBreed_group().isEmpty())?"Not available":dog.getBreed_group());
            }
        });
        dogDetailsViewModel.getBitmapMutableLiveData(idToSearch).observe(getViewLifecycleOwner(), bitmap -> {
            if (bitmap != null){
                binding.dogDetailsImageViewDogPhoto.setImageBitmap(bitmap);
            }
        });
    }
}
