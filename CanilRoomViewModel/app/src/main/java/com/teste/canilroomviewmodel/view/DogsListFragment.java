package com.teste.canilroomviewmodel.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.teste.canilroomviewmodel.Adapters.DogsAdapter;
import com.teste.canilroomviewmodel.R;
import com.teste.canilroomviewmodel.database.DogNameId;
import com.teste.canilroomviewmodel.databinding.FragmentDogsListBinding;
import com.teste.canilroomviewmodel.retrofit.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DogsListFragment extends Fragment {

    private static final String TAG = DogsListFragment.class.getSimpleName();
    private FragmentDogsListBinding binding;
    private RetrofitConfig retrofitConfig;
    private Call<List<DogNameId>> dogCall;
    private List<DogNameId> dogNameIds;
    private DogsAdapter adapter;

    public DogsListFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDogsListBinding.inflate(getLayoutInflater(),container,false);
        View rootView = binding.getRoot();
        retrofitConfig = new RetrofitConfig();

        binding.recyclerViewDogs.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerViewDogs.setHasFixedSize(true);


        dogCall = retrofitConfig.getDogAPI().getAllBreeds();
        dogCall.enqueue(new Callback<List<DogNameId>>() {
            @Override
            public void onResponse(Call<List<DogNameId>> call, Response<List<DogNameId>> response) {
                dogNameIds = response.body();
                adapter = new DogsAdapter(dogNameIds);
                binding.recyclerViewDogs.setAdapter(adapter);
                Log.e(TAG,"Response code: " +response.code());
        }

            @Override
            public void onFailure(Call<List<DogNameId>> call, Throwable t) {
                Log.e(TAG,"Failed\nError: "+t.getMessage());
            }
        });
        return rootView;
    }
}
