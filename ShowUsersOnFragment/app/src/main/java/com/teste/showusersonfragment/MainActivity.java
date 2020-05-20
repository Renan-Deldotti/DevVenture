package com.teste.showusersonfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SelectUserFragment.OnSelectUserListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_select_user, SelectUserFragment.newInstance())
                .commit();
    }

    @Override
    public void onUserSelected(int id) {
        Toast.makeText(this, "Selected user: "+id, Toast.LENGTH_SHORT).show();
    }
}
