package com.teste.cartaodevisita;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int CAMERA_REQUEST = 1;
    public static final int CAMERA_MANIFEST = 2;

    private TextView textViewModeloGerado;
    private EditText editTextName, editTextEmpresa, editTextEmail;
    private FrameLayout frameLayoutContatoGerado;
    private Bitmap bitmapPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editText_name);
        editTextEmpresa = findViewById(R.id.editText_empresa);
        editTextEmail = findViewById(R.id.editText_email);

        textViewModeloGerado = findViewById(R.id.textView_modeloGerado);
        frameLayoutContatoGerado = findViewById(R.id.frame_contatoGerado);

        ImageButton buttonTakePicture = findViewById(R.id.buttonTakePicture);
        buttonTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED){
                    ActivityCompat.requestPermissions(MainActivity.this,new String[] {Manifest.permission.CAMERA}, CAMERA_MANIFEST);
                }
                Intent openCamera = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(openCamera, CAMERA_REQUEST);
            }
        });


        Button buttonCriar = findViewById(R.id.buttonCriar);
        buttonCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criaModelo();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            if (data != null && data.getExtras() != null) {
                bitmapPhoto = (Bitmap) data.getExtras().get("data");
            }
        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void criaModelo() {

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (getCurrentFocus() != null && imm != null){imm.hideSoftInputFromWindow(getCurrentFocus() .getApplicationWindowToken(), 0);}

        TextView textViewName = findViewById(R.id.textView_nome);
        TextView textViewEmpresa = findViewById(R.id.textView_empresa);
        TextView textViewEmail = findViewById(R.id.textView_email);
        ImageView imageView = findViewById(R.id.imageView);

        if (TextUtils.isEmpty(editTextName.getText().toString().trim()) || TextUtils.isEmpty(editTextEmpresa.getText().toString().trim()) || TextUtils.isEmpty(editTextEmail.getText().toString().trim())){
            if (bitmapPhoto == null){
                Toast.makeText(this, "Tire uma foto", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "Todos os campos são necessários", Toast.LENGTH_SHORT).show();
            return;
        }

        textViewName.setText(editTextName.getText().toString().trim());
        textViewEmpresa.setText(editTextEmpresa.getText().toString().trim());
        textViewEmail.setText(editTextEmail.getText().toString().trim());

        imageView.setImageBitmap(bitmapPhoto);


        if (textViewModeloGerado.getVisibility() != View.VISIBLE){
            textViewModeloGerado.setVisibility(View.VISIBLE);
            frameLayoutContatoGerado.setVisibility(View.VISIBLE);
        }
    }
}
