package com.example.meghana.ui;

/**
 * Created by MEGHANA on 10-06-2017.
 */


        import android.app.Activity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;

/**
 * Created by WINDOWS on 10-06-2017.
 */

public class Claimok extends Activity{
    Button udci;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploadclaim);
        udci = (Button) findViewById(R.id.ucdd);
        udci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "your claim cheque will be recieved lately",Toast.LENGTH_LONG).show();
            }
        });
    }

}
