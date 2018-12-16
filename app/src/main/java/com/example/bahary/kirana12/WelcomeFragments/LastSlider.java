package com.example.bahary.kirana12.WelcomeFragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.bahary.kirana12.LoginActivity;
import com.example.bahary.kirana12.R;
import com.example.bahary.kirana12.RegistrationActivity;
import com.example.bahary.kirana12.Utils.Constants;
import com.orhanobut.hawk.Hawk;

/**
 * A simple {@link Fragment} subclass.
 */
public class LastSlider extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.slider3, container, false);
        Button signin = view.findViewById(R.id.slidersignin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        Button signup=view.findViewById(R.id.slidersignup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),RegistrationActivity.class);
                startActivity(intent);
                getActivity().finish();

            }
        });
        return view;
    }
}
