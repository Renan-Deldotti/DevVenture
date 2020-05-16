package com.teste.cartaodevisita;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textViewModeloGerado;
    private EditText editTextName, editTextEmpresa, editTextEmail;
    private FrameLayout frameLayoutContatoGerado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editText_name);
        editTextEmpresa = findViewById(R.id.editText_empresa);
        editTextEmail = findViewById(R.id.editText_email);

        textViewModeloGerado = findViewById(R.id.textView_modeloGerado);
        frameLayoutContatoGerado = findViewById(R.id.frame_contatoGerado);

        Button buttonCriar = findViewById(R.id.buttonCriar);
        buttonCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criaModelo();
            }
        });
    }

    private void criaModelo() {

        TextView textViewName = findViewById(R.id.textView_nome);
        TextView textViewEmpresa = findViewById(R.id.textView_empresa);
        TextView textViewEmail = findViewById(R.id.textView_email);
        ImageView imageView = findViewById(R.id.imageView);

        if (TextUtils.isEmpty(editTextName.getText().toString().trim()) || TextUtils.isEmpty(editTextEmpresa.getText().toString().trim()) || TextUtils.isEmpty(editTextEmail.getText().toString().trim())){
            Toast.makeText(this, "Todos os campos são necessários", Toast.LENGTH_SHORT).show();
            return;
        }

        textViewName.setText(editTextName.getText().toString().trim());
        textViewEmpresa.setText(editTextEmpresa.getText().toString().trim());
        textViewEmail.setText(editTextEmail.getText().toString().trim());

        imageView.setImageResource(R.drawable.ic_camera);


        if (textViewModeloGerado.getVisibility() != View.VISIBLE){
            textViewModeloGerado.setVisibility(View.VISIBLE);
            frameLayoutContatoGerado.setVisibility(View.VISIBLE);
        }
    }
}
