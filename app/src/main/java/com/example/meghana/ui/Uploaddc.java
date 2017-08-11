package com.example.meghana.ui;

/**
 * Created by MEGHANA on 10-06-2017.
 */

import android.os.Bundle;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;

/**
 * Created by WINDOWS on 10-06-2017.
 */

public class Uploaddc extends Activity {
    Button udci;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploaddc);
        udci = (Button) findViewById(R.id.gc);
        udci = (Button) findViewById(R.id.udc);
        udci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Uploaded death certificate reference to blockchain",Toast.LENGTH_LONG).show();
            }
        });
    }

}