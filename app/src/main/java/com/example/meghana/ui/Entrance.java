package com.example.meghana.ui;

/**
 * Created by MEGHANA on 09-06-2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Entrance extends AppCompatActivity {
    LinearLayout start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);
        start = (LinearLayout)findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Entrance.this, Buttons.class);
                startActivity(in);
            }
        });
    }
}
