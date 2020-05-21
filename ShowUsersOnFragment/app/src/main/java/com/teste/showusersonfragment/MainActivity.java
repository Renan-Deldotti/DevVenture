package com.teste.showusersonfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements SelectUserFragment.OnSelectUserListener {

    private List<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createUserList();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_select_user, SelectUserFragment.newInstance())
                .commit();
    }

    @Override
    public void onUserSelected(int id) {
        Toast.makeText(this, "Selected user: "+id, Toast.LENGTH_SHORT).show();
        updateUserDetailFragment(id);
    }

    private void updateUserDetailFragment(int id){
        int userPosition = id - 1;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_show_user, UserDetailFragment.newInstance(userList.get(userPosition)))
                .commit();
    }

    private void createUserList(){
        userList.add(new User(1,"John","The Great"));
        userList.add(new User(2,"Marie","The Rock Breaker"));
        userList.add(new User(3,"Joseph","The Swordsman"));
    }

}
