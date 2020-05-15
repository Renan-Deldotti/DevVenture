package com.teste.controlpanellab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;
    private ColorStateList colorStateList;

    private static String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = findViewById(R.id.editText);
        colorStateList = editText.getBackgroundTintList();

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "onClick", Toast.LENGTH_SHORT).show();
                editText.clearFocus();
            }
        });

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(LOG_TAG,"hasFocus: "+hasFocus);
                if (hasFocus){
                    editText.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    editText.setError(null);
                }else{
                    editText.setBackgroundTintList(colorStateList);
                    editText.setError("error");
                }
            }
        });

        /*editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("activity")){
                    Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
                    editText.setError(null);
                }else {
                    editText.setError("error");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.name_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_help:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_refresh:
                Snackbar.make(findViewById(R.id.mainLayout),"Teste", BaseTransientBottomBar.LENGTH_LONG).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
