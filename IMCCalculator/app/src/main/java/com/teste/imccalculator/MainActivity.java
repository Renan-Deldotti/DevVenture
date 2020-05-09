package com.teste.imccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAltura, editTextPeso;
    private TextView textViewResult,textViewIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAltura = findViewById(R.id.editText_altura);
        editTextPeso = findViewById(R.id.editText_peso);
        textViewResult = findViewById(R.id.textView_result);
        textViewIMC = findViewById(R.id.textView_imc_index);
        editTextAltura.setTextLocale(Locale.getDefault());
        editTextAltura.clearFocus();
    }

    public void calcular(View view) {
        float altura,peso,result;



        if (TextUtils.isEmpty(editTextAltura.getText().toString())){
            Toast.makeText(this, "Altura vazia", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(editTextPeso.getText().toString()) || (editTextPeso.getText().toString().equals("0"))) {
            Toast.makeText(this, "Peso vazio ou igual a 0", Toast.LENGTH_SHORT).show();
        }else {
            altura = Float.parseFloat(editTextAltura.getText().toString());
            peso = Float.parseFloat(editTextPeso.getText().toString());
            result = (float) (peso / Math.pow(altura,2));

            if (result < 25){
                textViewIMC.setText("Bom");
            }else if(result < 30){
                textViewIMC.setText("Acima");
            }else{
                textViewIMC.setText("Cuidado");
            }
            Toast.makeText(this, ""+((Button)view).getText(), Toast.LENGTH_SHORT).show();
            textViewResult.setText(String.valueOf(result));
        }
        hideKeyBoard(view);
    }
    private void hideKeyBoard(View view){
        InputMethodManager inputMethodManager = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}
