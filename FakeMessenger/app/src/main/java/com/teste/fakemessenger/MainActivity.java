package com.teste.fakemessenger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_ID = MainActivity.class.getSimpleName() + " Message";
    public static final int REQUEST_ANSWER = 1;

    private EditText editTextMessage;
    private TextView textViewAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextMessage = findViewById(R.id.editText_message);
        textViewAnswer = findViewById(R.id.textView_answer);

        if (savedInstanceState == null){
            Toast.makeText(this, "savedInstanceState == null", Toast.LENGTH_SHORT).show();
        }else{
            textViewAnswer.setText(savedInstanceState.getString("savedtext"));
        }
    }

    public void callNewActivity(View view) {
        Intent intent = new Intent (MainActivity.this,NewActivity.class);
        intent.putExtra(EXTRA_ID,editTextMessage.getText().toString().trim());
        startActivity(intent);
    }

    public void callNewActivityForResult(View view) {
        Intent intent = new Intent (MainActivity.this,NewActivity.class);
        intent.putExtra(EXTRA_ID,editTextMessage.getText().toString().trim());
        startActivityForResult(intent,REQUEST_ANSWER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_ANSWER){
            if (resultCode == RESULT_OK){
                if (data!=null && data.hasExtra(NewActivity.ANSWER_ID)){
                    textViewAnswer.setText(data.getStringExtra(NewActivity.ANSWER_ID));
                }
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (!TextUtils.isEmpty(textViewAnswer.getText().toString().trim())){
            outState.putString("savedtext",textViewAnswer.getText().toString().trim());
        }
    }
}
