package com.teste.fragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.PictureInPictureParams;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.Rational;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnFragmentMessageChanged {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FirstFragment firstFragment;
    SecondFragment secondFragment;

    FrameLayout frameLayoutFragment1;
    FrameLayout frameLayoutFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragment = FirstFragment.newInstance("Este é um novo fragment!");
        secondFragment = SecondFragment.newInstance("Segunda Fragment");

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment1_Container, firstFragment)
                .add(R.id.fragment2_Container,secondFragment)
                .commit();

        frameLayoutFragment1 = findViewById(R.id.fragment1_Container);
        frameLayoutFragment2 = findViewById(R.id.fragment2_Container);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_pip) {
            pipMode();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void pipMode() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            //DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            //Rational rational = new Rational(Math.round(displayMetrics.xdpi), Math.round(displayMetrics.ydpi)); // Auto
            //Rational rational = new Rational( 16, 9); // 16:9
            //Rational rational = new Rational( 4, 3); // 4:3
            Rational rational = new Rational( frameLayoutFragment2.getWidth(), frameLayoutFragment2.getHeight());
            PictureInPictureParams params = new PictureInPictureParams.Builder().setAspectRatio(rational).build();
            enterPictureInPictureMode(params);
        }
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        if (isInPictureInPictureMode){
            frameLayoutFragment1.setVisibility(View.GONE);
        }else {
            frameLayoutFragment1.setVisibility(View.VISIBLE);
        }
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);

    }

    @Override
    public void onMessageChanged(String message) {
        updateFragment2(message);
    }

    private void updateFragment2(String message){
        SecondFragment secondFragment = SecondFragment.newInstance(message);
        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.fragment2_Container, secondFragment)
                .commit();
    }
}
