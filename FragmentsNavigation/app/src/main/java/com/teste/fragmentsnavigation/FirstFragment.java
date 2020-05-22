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
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    public static final String EDIT_TEXT_KEY = "edit_text_key";
    public static final String SWITCH1_KEY = "switch1_key";
    public static final String SWITCH2_KEY = "switch2_key";
    public static final String SEEKBAR_KEY = "seekbar_key";

    private EditText editText;
    private Switch switch1,switch2;
    private Button buttonNavigate;
    private SeekBar seekBar;
    private SharedPreferences sharedPreferences;
    private String sharedPref = "SharedPref";

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        buttonNavigate = v.findViewById(R.id.buttonNavigate);
        seekBar = v.findViewById(R.id.seekBar);
        editText = v.findViewById(R.id.editText);
        switch1 = v.findViewById(R.id.switch1);
        switch2 = v.findViewById(R.id.switch2);

        if (getContext()!=null)
        sharedPreferences = getContext().getSharedPreferences(sharedPref, Context.MODE_PRIVATE);


        editText.setText(sharedPreferences.getString(EDIT_TEXT_KEY, "Não encontrado."));
        switch1.setChecked(sharedPreferences.getBoolean(SWITCH1_KEY,true));
        switch2.setChecked(sharedPreferences.getBoolean(SWITCH2_KEY,true));
        seekBar.setProgress(sharedPreferences.getInt(SEEKBAR_KEY,100));


        Button buttonReset = v.findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetSharedPreferences();
            }
        });

        return v;
    }

    @Override
    public void onPause() {
        Log.e(FirstFragment.class.getSimpleName(),""+editText.getText().toString().trim());
        super.onPause();
        SharedPreferences.Editor sharedEditor = sharedPreferences.edit();
        sharedEditor.putString(EDIT_TEXT_KEY, editText.getText().toString().trim());
        sharedEditor.putBoolean(SWITCH1_KEY, switch1.isChecked());
        sharedEditor.putBoolean(SWITCH2_KEY,switch2.isChecked());
        sharedEditor.putInt(SEEKBAR_KEY,seekBar.getProgress());

        sharedEditor.apply();
    }

    private void resetSharedPreferences(){
        editText.setText("");
        switch1.setChecked(false);
        switch2.setChecked(false);
        seekBar.setProgress(0);
        SharedPreferences.Editor shared = sharedPreferences.edit();
        shared.clear();
        shared.apply();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = FirstFragmentDirections.actionToSecondFragment(10);
                Navigation.findNavController(v).navigate(action);
            }
        });
    }
}
