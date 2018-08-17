package com.example.bahary.kirana12;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bahary.kirana12.Utils.Constants;
import com.orhanobut.hawk.Hawk;

public class LoginActivity extends AppCompatActivity {
    EditText name, pass;
    TextView forget_pass, creat_accout;
    Button log_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Hawk.init(this).build();
        Hawk.put(Constants.Welcome_Flag, "1");
        */
        name = findViewById(R.id.input_name);
        pass = findViewById(R.id.input_pass);
        forget_pass = findViewById(R.id.forget_pass);
        creat_accout = findViewById(R.id.sign_up);
        log_in = findViewById(R.id.sign_in_button);
        creat_accout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(intent);
            }
        });
        ImageView bar_image=findViewById(R.id.toolbarback);
        bar_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View parentLayout = findViewById(android.R.id.content);
                Snackbar.make(parentLayout, "Are you sure you want to exit ?", Snackbar.LENGTH_LONG)
                        .setAction("Exit", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                finish();
                            }
                        })
                        .setActionTextColor(getResources().getColor(android.R.color.holo_red_light))
                        .show();
            }
        });
        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString() == "" || pass.getText().toString() == "") {
                } else {
                    Toast.makeText(LoginActivity.this, "New Intent", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(getApplicationContext(),Home1Activity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}
