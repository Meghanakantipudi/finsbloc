package com.example.meghana.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by MEGHANA on 09-06-2017.
 */

public class Hospital_main extends Activity {
    Button h_login, h_reg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_main);
         h_login = (Button) findViewById(R.id.h_login);
         h_reg = (Button) findViewById(R.id.h_regi);

         h_login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent in = new Intent(Hospital_main.this, Hospital_Login.class);
                 startActivity(in);
             }
         });
         h_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Hospital_main.this, Hospital_Registration.class);
                startActivity(in);
            }
        });
    }
}
