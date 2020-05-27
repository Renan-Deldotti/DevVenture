package com.teste.viewmodellab.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.teste.viewmodellab.R;
import com.teste.viewmodellab.viewModel.MyViewModel;

public class MainActivity extends AppCompatActivity {

    private MyViewModel viewModel;
    private TextView textView;
    private Button buttonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()).create(MyViewModel.class);
        textView = findViewById(R.id.textView);
        buttonName = findViewById(R.id.button_newName);

        viewModel.getName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });

        buttonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    @Override
                    public void run() {
                        viewModel.getName().setValue("New Dev Venture class");
                    }
                }.start();
            }
        });
    }
}
