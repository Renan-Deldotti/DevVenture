package com.teste.showusersonfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;



/**
 * A simple {@link Fragment} subclass.
 */
public class UserDetailFragment extends Fragment {

    private static final String USER_ARGUMENT = "USER_ARG";

    private TextView textViewId, textViewName, textViewNickname;

    public UserDetailFragment() {
        // Required empty public constructor
    }

    public static UserDetailFragment newInstance(User user){
        UserDetailFragment userDetailFragment = new UserDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(USER_ARGUMENT, user);
        userDetailFragment.setArguments(bundle);
        return userDetailFragment;
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_user_detail, container, false);

        textViewId = v.findViewById(R.id.textView_userId);
        textViewName = v.findViewById(R.id.textView_userName);
        textViewNickname = v.findViewById(R.id.textView_userNickname);

        if (getArguments() != null){
            User user = (User) getArguments().getSerializable(USER_ARGUMENT);
            if (user == null){
                return v;
            }
            textViewId.setText(String.valueOf(user.getId()));
            textViewName.setText(user.getName());
            textViewNickname.setText(user.getNickName());
        }


        return v;
    }
}
