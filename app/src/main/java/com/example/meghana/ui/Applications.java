package com.example.meghana.ui;

/**
 * Created by MEGHANA on 08-06-2017.
 */


        import android.app.Activity;
        import android.content.Intent;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

/**
 * Created by WINDOWS on 07-06-2017.
 */

public class Applications extends Activity {
    Button myBut;
    TextView textid;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.applications);
        textid = (TextView)findViewById(R.id.textid);
        myBut = (Button) findViewById(R.id.butt1);
        myBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s= textid.getText().toString().trim();
                Intent i = new Intent(new Intent(Applications.this, Details_display.class));
                i.putExtra("ids", s);
                startActivity(i);
            }
        });
    }
}
