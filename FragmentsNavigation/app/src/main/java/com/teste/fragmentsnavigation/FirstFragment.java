package com.teste.fragmentsnavigation;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teste.fragmentsnavigation.databinding.FragmentFirstBinding;


public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    private static final String EDIT_TEXT_KEY = "edit_text_key";
    private static final String SWITCH1_KEY = "switch1_key";
    private static final String SWITCH2_KEY = "switch2_key";
    private static final String SEEKBAR_KEY = "seekbar_key";

    private SharedPreferences sharedPreferences;
    private static final String sharedPref = "SharedPref";

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater,container,false);
        View v = binding.getRoot();

        if (getContext()!=null)
        sharedPreferences = getContext().getSharedPreferences(sharedPref, Context.MODE_PRIVATE);

        binding.editText.setText(sharedPreferences.getString(EDIT_TEXT_KEY, "Não encontrado."));
        binding.switch1.setChecked(sharedPreferences.getBoolean(SWITCH1_KEY,true));
        binding.switch2.setChecked(sharedPreferences.getBoolean(SWITCH2_KEY,true));
        binding.seekBar.setProgress(sharedPreferences.getInt(SEEKBAR_KEY,100));


        binding.buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetSharedPreferences();
            }
        });
        return v;
    }

    @Override
    public void onPause() {
        Log.e(FirstFragment.class.getSimpleName(),""+binding.editText.getText().toString().trim());
        super.onPause();
        SharedPreferences.Editor sharedEditor = sharedPreferences.edit();
        sharedEditor.putString(EDIT_TEXT_KEY, binding.editText.getText().toString().trim());
        sharedEditor.putBoolean(SWITCH1_KEY, binding.switch1.isChecked());
        sharedEditor.putBoolean(SWITCH2_KEY,binding.switch2.isChecked());
        sharedEditor.putInt(SEEKBAR_KEY,binding.seekBar.getProgress());

        sharedEditor.apply();
    }

    private void resetSharedPreferences(){
        binding.editText.setText("");
        binding.switch1.setChecked(false);
        binding.switch2.setChecked(false);
        binding.seekBar.setProgress(0);
        SharedPreferences.Editor shared = sharedPreferences.edit();
        shared.clear();
        shared.apply();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = FirstFragmentDirections.actionToSecondFragment(10);
                Navigation.findNavController(v).navigate(action);
            }
        });
    }
}
