package com.example.meghana.ui;

/**
 * Created by MEGHANA on 08-06-2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by WINDOWS on 08-06-2017.
 */

public class Nominee_ids extends Activity {
    Button myBut;
    TextView textids;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appnom);
        textids = (TextView)findViewById(R.id.textida);
        myBut = (Button) findViewById(R.id.butt1);
        myBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String s=textids.getText().toString();
                //Toast.makeText(getBaseContext(), "hbfjdsjnsjk", Toast.LENGTH_LONG).show();
                Intent i = new Intent(Nominee_ids.this, Nominee_details.class);
                //i.putExtra("idss", s);
                startActivity(i);
            }
        });
    }
}
