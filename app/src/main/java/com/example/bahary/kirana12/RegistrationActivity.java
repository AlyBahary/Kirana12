package com.example.bahary.kirana12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //View view = getLayoutInflater().inflate( R.layout.action_bar,null);
        TextView bar_title=findViewById(R.id.toolbar_title);
        bar_title.setText("Sign up");
    }
}
