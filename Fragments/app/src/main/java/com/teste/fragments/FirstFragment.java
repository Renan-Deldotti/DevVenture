package com.teste.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    public static final String FRAGMENT1_MESSAGE = "FRAG1_MSG";

    private OnFragmentMessageChanged listener;

    private TextView textView;
    private String message;
    private Button sendMessageButton;

    public FirstFragment() {
        // Required empty public constructor
    }

    public interface OnFragmentMessageChanged {
        public void onMessageChanged(String message);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentMessageChanged){
            this.listener = (OnFragmentMessageChanged) context;
        }else {
            throw new ClassCastException(context.toString() + " precisa implementar a interface onFragmentMessageChange");
        }
    }

    public static FirstFragment newInstance(String message){
        FirstFragment fragment = new FirstFragment();
        Bundle bundleArgs = new Bundle();
        bundleArgs.putString(FRAGMENT1_MESSAGE,message);
        fragment.setArguments(bundleArgs);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);

        textView = v.findViewById(R.id.textView);
        sendMessageButton = v.findViewById(R.id.fragment1_button);

        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onMessageChanged("Olá Fragment2!");
            }
        });

        if (getArguments() != null){
            message = getArguments().getString(FRAGMENT1_MESSAGE);
            textView.setText(message);
        }

        return v;
    }
}
