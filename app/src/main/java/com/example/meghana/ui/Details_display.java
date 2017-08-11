package com.example.meghana.ui;

/**
 * Created by MEGHANA on 08-06-2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by WINDOWS on 07-06-2017.
 */

public class Details_display extends Activity {
    TextView name,identity,nation,birth,death,place;
    Button vefy, bgc;
    String pid,TAG;
    int i = 1;
    String dec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_display);
        Intent in = getIntent();
        String nid;
        nid = getIntent().getStringExtra("ids");
        name = (TextView) findViewById(R.id.tv1);
        identity = (TextView) findViewById(R.id.tv2);
        nation = (TextView) findViewById(R.id.tv3);
        birth = (TextView) findViewById(R.id.tv4);
        death=(TextView)findViewById(R.id.tv5);
        place=(TextView)findViewById(R.id.tv6);
        vefy =(Button)findViewById(R.id.verify);
        bgc = (Button) findViewById(R.id.gc);
        bgc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Death Certificate will be uploaded soon", Toast.LENGTH_LONG).show();
                Intent i = new Intent(Details_display.this, Buttons.class);
                startActivity(i);
            }
        });
        vefy.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "details successfully verified",Toast.LENGTH_LONG).show();
            }
        });
        if (i < 0){
            Log.i("i =", String.valueOf(i));
            try {
                String url = ConnectionUtil.URL + "Servlet_details?nomid="+nid;
                System.out.println(url);
                Log.i("url ", url);
                url = url.trim();
                url = url.replace(" ","%20");
                i = -1;
                Log.i("i =", String.valueOf(i));
                GetXMLTask task = new GetXMLTask();
                task.execute(new String[]{url});

            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }
    public class GetXMLTask extends AsyncTask<String, Void, String> {
        public String output = null;
        @Override
        protected String doInBackground(String... urls) {
            //Toast.makeText(this, "in XML", 5000).show();
            //System.out.println("sdsd");
            System.out.println("in xml");
            String output = null;
            for (String url : urls) {
                output = getOutputFromUrl(url);
            }
            return output;
        }
        private String getOutputFromUrl(String url) {
            String output = null;
            try {
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpGet httpGet = new HttpGet(url);

                HttpResponse httpResponse = httpClient.execute(httpGet);
                HttpEntity httpEntity = httpResponse.getEntity();
                output = EntityUtils.toString(httpEntity);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return output;
        }
        @Override
        protected void onPostExecute(String output) {
            // outputText.setText(output);
            String status = output;
            status = status.trim();
            System.out.println(status);
            Toast.makeText(getBaseContext(), status, Toast.LENGTH_LONG).show();
            if (status.equals("exception")) {
                Toast.makeText(getBaseContext(), "Some problem Occured at the server", Toast.LENGTH_LONG).show();
            } else if (status.equals("Unsuccessful")) {
                Toast.makeText(getBaseContext(), "Invalid Username/Password, Pls try again", Toast.LENGTH_LONG).show();
            } else if (status.equals("Successfully updated")) {
                /*Intent in = new Intent(CustomerdataI.this,HomePage.class);
                startActivity(in);*/
                Toast.makeText(getBaseContext(), "Valid User", Toast.LENGTH_LONG).show();

            } else if (status.equals("failed to update")) {
                //Intent in = new Intent(LoanDetails.this,HomePage.class);
                //startActivity(in) ;
                Toast.makeText(getBaseContext(), "Failed to Update your decision", Toast.LENGTH_LONG).show();

            }else {
                if(!status.equals("")) {
                    String req[] = status.split(":");
                    int i = 0;
                    while(i <req.length){
                        System.out.println(req[i]);
                        i++;
                    }
                    Log.i(TAG ,"after while");

                    name.setText(req[0]);
                    identity.setText(req[1]);
                    nation.setText(req[2]);
                    birth.setText(req[3]);
                    death.setText(req[4]);
                    place.setText(req[5]);
                }else {
                    Toast.makeText(Details_display.this, "No data available", Toast.LENGTH_LONG).show();
                }
            }

        }
    }
}