package com.teste.fakemessenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    public static final String ANSWER_ID = NewActivity.class.getSimpleName() + " ANSWER";

    private TextView textViewMessageReceived;
    private EditText editTextAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        textViewMessageReceived = findViewById(R.id.textView_message);
        editTextAnswer = findViewById(R.id.editTextAnswer);

        Intent intent = getIntent();
        if (intent.hasExtra(MainActivity.EXTRA_ID)){
            textViewMessageReceived.setText(intent.getStringExtra(MainActivity.EXTRA_ID));
        }else{
            textViewMessageReceived.setText("Não há menssagens");
        }
    }

    public void sendAnswer(View view) {
        String answer = editTextAnswer.getText().toString().trim();
        Intent answerIntent = new Intent();
        answerIntent.putExtra(ANSWER_ID,answer);
        setResult(RESULT_OK,answerIntent);
        finish();
    }
}
