package com.teste.parouimpar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private static final int PAR = 0;
    private static final int IMPAR = 1;

    private TextView textViewPlacarJogador, textViewPlacarMaquina, textViewEscolhaMaquina, textViewWinner;
    private int selectVal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewPlacarJogador = findViewById(R.id.placar_jogador);
        textViewPlacarMaquina = findViewById(R.id.placar_maquina);
        textViewEscolhaMaquina = findViewById(R.id.textView_escolha_maquina);
        textViewWinner = findViewById(R.id.textView_winner);
        Button buttonPar = findViewById(R.id.button_par);
        Button buttonImpar = findViewById(R.id.button_impar);


        restartAll();

        buttonPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectVal == 0){
                    Toast.makeText(MainActivity.this, "Selecione um valor", Toast.LENGTH_SHORT).show();
                    return;
                }
                checkWinner(selectVal,PAR);
            }
        });

        buttonImpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectVal == 0){
                    Toast.makeText(MainActivity.this, "Selecione um valor", Toast.LENGTH_SHORT).show();
                    return;
                }
                checkWinner(selectVal,IMPAR);
            }
        });
    }

    private void checkWinner(int selectVal, int guess) {
        int escolhaMaquina = new Random().nextInt(6);

        boolean isPar = ((selectVal + escolhaMaquina) % 2) == 0;

        boolean isWinner = false;

        textViewEscolhaMaquina.setText(String.valueOf(escolhaMaquina));

        if (guess == PAR && isPar){
            isWinner = true;
        }else if (guess == IMPAR && !isPar){
            isWinner = true;
        }

        if (isWinner){
            textViewWinner.setText(R.string.winner);
            int placarJogador = Integer.parseInt(textViewPlacarJogador.getText().toString().trim()) + 1;
            textViewPlacarJogador.setText(String.valueOf(placarJogador));
        }else{
            textViewWinner.setText(R.string.loser);
            int placarMaquina = Integer.parseInt(textViewPlacarMaquina.getText().toString().trim()) + 1;
            textViewPlacarMaquina.setText(String.valueOf(placarMaquina));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.restart){
            restartAll();
            return true;
        }else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void restartAll() {
        textViewPlacarMaquina.setText(String.valueOf(0));
        textViewPlacarJogador.setText(String.valueOf(0));
        textViewEscolhaMaquina.setText(String.valueOf(0));
        textViewWinner.setText(getResources().getString(R.string.iniciar));
    }

    public void selectOption(View v){
        try {
            selectVal = Integer.parseInt(((Button)v).getText().toString());
        } catch (NumberFormatException e) {
            selectVal = 0;
            Log.e(TAG,"Error: "+e);
        }
    }
}
