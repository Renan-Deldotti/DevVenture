package com.teste.fragmentsnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.customview.widget.Openable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.net.IpSecManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toast testeToast;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navController = Navigation.findNavController(this,R.id.fragment_nav_controller);
        NavigationUI.setupActionBarWithNavController(this,navController);



        checkToast("Teste");

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            checkToast("Canceled");
                        }
                    });
                } catch (InterruptedException e) {
                    Log.e("ErrorFN","Error: "+e);
                }
            }
        };
        thread.start();
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, (Openable) null);
    }

    private void checkToast(String message){
        if (testeToast != null){
            testeToast.cancel();
        }
        testeToast = Toast.makeText(this,message,Toast.LENGTH_SHORT);
        testeToast.show();
    }
}
