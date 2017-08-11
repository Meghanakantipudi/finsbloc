package com.example.meghana.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by MEGHANA on 09-06-2017.
 */

public class Buttons extends Activity {
    ImageButton b1, b2, b3, b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttons);
        b1 = (ImageButton)findViewById(R.id.nc);
        b2 = (ImageButton) findViewById(R.id.nh);
        b3 = (ImageButton) findViewById(R.id.nsh);
        b4 = (ImageButton) findViewById(R.id.nic);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Buttons.this, Mainpage.class);
                startActivity(in);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in1 = new Intent(Buttons.this, Hospital_main.class);
                startActivity(in1);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in2 = new Intent(Buttons.this, State_health_login.class);
                startActivity(in2);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in3 = new Intent(Buttons.this, Insurance_login.class);
                startActivity(in3);
            }
        });
    }
}
