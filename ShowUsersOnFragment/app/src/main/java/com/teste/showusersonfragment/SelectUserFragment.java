package com.teste.showusersonfragment;

import android.content.Context;
import android.net.sip.SipSession;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class SelectUserFragment extends Fragment implements View.OnClickListener{

    private static OnSelectUserListener listener;

    private Button button1, button2, button3;

    public SelectUserFragment() {
        // Required empty public constructor
    }

    public static SelectUserFragment newInstance() {
        SelectUserFragment fragment = new SelectUserFragment();
        // Caso hajam parametros deverao ser colocados dentro de um bundle
        // e passado atraves do metodo fragment.setArguments
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnSelectUserListener){
            listener = (OnSelectUserListener) context;
        }else {
            throw new ClassCastException("Zebra! Contexto não implementa a interface OnSelectedUserListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_select_user, container, false);
        button1 = v.findViewById(R.id.button1);
        button2 = v.findViewById(R.id.button2);
        button3 = v.findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        // Caso existam parametros checar o objeto e pegar os dados

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                listener.onUserSelected(1);
                break;
            case R.id.button2:
                listener.onUserSelected(2);
                break;
            default:
                listener.onUserSelected(3);
        }
    }

    /*private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button1:
                    listener.onUserSelected(1);
                    break;
                case R.id.button2:
                    listener.onUserSelected(2);
                    break;
                default:
                    listener.onUserSelected(3);
            }
        }
    };*/

    public interface OnSelectUserListener {
        void onUserSelected(int id);
    }
}
