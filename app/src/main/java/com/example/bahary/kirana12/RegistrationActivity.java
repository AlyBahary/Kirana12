package com.example.bahary.kirana12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //View view = getLayoutInflater().inflate( R.layout.action_bar,null);
        TextView bar_title=findViewById(R.id.toolbar_title);
        TextView sign_in=findViewById(R.id.sign_in);
        ImageView bar_image=findViewById(R.id.toolbarback);
        bar_title.setText("Sign up");
        bar_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             finish();
            }
        });
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
