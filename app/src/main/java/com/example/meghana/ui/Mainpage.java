package com.example.meghana.ui;

/**
 * Created by MEGHANA on 09-06-2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Mainpage extends AppCompatActivity {
    Button registration,login;
    ViewFlipper flip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        registration = (Button)findViewById(R.id.registration);
        login = (Button)findViewById(R.id.login);
        flip = (ViewFlipper)findViewById(R.id.flip);

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Mainpage.this, Insurance_details.class);
                startActivity(in);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Mainpage.this, Claim_login.class);
                startActivity(in);
            }
        });
    }
}
