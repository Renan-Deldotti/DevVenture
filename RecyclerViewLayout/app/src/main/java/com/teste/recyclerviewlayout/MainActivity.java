package com.teste.recyclerviewlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter adapter = new ListAdapter(populateList());
        recyclerView.setAdapter(adapter);
    }

    private List<Contact> populateList() {
        List<Contact> contactList = new ArrayList<>();
        Contact contact1 = new Contact("Robert Deniro","Actor",R.drawable.ic_android);
        Contact contact2 = new Contact("Bill Gates","Programmer",R.drawable.ic_sentiment);
        Contact contact3 = new Contact("Zeta Jones","Actress",R.drawable.ic_person);
        Contact contact4 = new Contact("Robert Deniro","Actor",R.drawable.ic_android);
        Contact contact5 = new Contact("Bill Gates","Programmer",R.drawable.ic_sentiment);
        Contact contact6 = new Contact("Zeta Jones","Actress",R.drawable.ic_person);
        Contact contact7 = new Contact("Robert Deniro","Actor",R.drawable.ic_android);
        Contact contact8 = new Contact("Bill Gates","Programmer",R.drawable.ic_sentiment);
        Contact contact9 = new Contact("Zeta Jones","Actress",R.drawable.ic_person);
        Contact contact10 = new Contact("Robert Deniro","Actor",R.drawable.ic_android);
        Contact contact11 = new Contact("Bill Gates","Programmer",R.drawable.ic_sentiment);
        Contact contact12 = new Contact("Zeta Jones","Actress",R.drawable.ic_person);
        Contact contact13 = new Contact("Robert Deniro","Actor",R.drawable.ic_android);
        Contact contact14 = new Contact("Bill Gates","Programmer",R.drawable.ic_sentiment);
        Contact contact15 = new Contact("Zeta Jones","Actress",R.drawable.ic_person);

        contactList.add(contact1);
        contactList.add(contact2);
        contactList.add(contact3);
        contactList.add(contact4);
        contactList.add(contact5);
        contactList.add(contact6);
        contactList.add(contact7);
        contactList.add(contact8);
        contactList.add(contact9);
        contactList.add(contact10);
        contactList.add(contact11);
        contactList.add(contact12);
        contactList.add(contact13);
        contactList.add(contact14);
        contactList.add(contact15);
        return contactList;
    }
}
