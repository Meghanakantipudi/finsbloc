
package com.example.meghana.ui;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by WINDOWS on 08-06-2017.
 */

public class Nominee_details extends Activity {
    TextView nname, nidentity, nrelation, nnation, nbirth, nocc, mobile;
    Button claim, vfy;
    String pid, TAG;
    int i = 1;
    String dec;
    Button bs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nominee_details);
        Log.i(TAG + "", "Insurance details");
        Intent in = getIntent();
        String nid = in.getStringExtra("ids");
        nid = getIntent().getStringExtra("value");
        nname = (TextView) findViewById(R.id.dtv1);
        nidentity = (TextView) findViewById(R.id.dtv2);
        nnation = (TextView) findViewById(R.id.dtv3);
        nrelation = (TextView) findViewById(R.id.dtv4);
        nbirth = (TextView) findViewById(R.id.dtv5);
        nocc = (TextView) findViewById(R.id.dtv6);
        mobile = (TextView) findViewById(R.id.dtv7);
        //bs = (Button) findViewById(R.id.verify);
        claim = (Button) findViewById(R.id.icd);
        vfy = (Button) findViewById(R.id.checks);
        /*bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Nominee_details, )
                Toast.makeText(getBaseContext(), "verifying the details", Toast.LENGTH_LONG).show();

            }
        });*/


        vfy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Details successfully Verified", Toast.LENGTH_LONG).show();
            }
        });
         claim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "check will be received soon", Toast.LENGTH_LONG).show();

                Intent in = new Intent(Nominee_details.this, Buttons.class);
                startActivity(in);
            }
        });
       /* if (i < 0){
            Log.i("i =", String.valueOf(i));
            try {
                String url = ConnectionUtil.URL + "InsureDetails?nomid="+nid;
                System.out.println(url);
                Log.i("url ", url);
                url = url.trim();
                url = url.replace(" ","%20");
                i = -1;
                Log.i("i =", String.valueOf(i));
                Nominee_details.GetXMLTask task = new Nominee_details.GetXMLTask();
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
                /*Toast.makeText(getBaseContext(), "Valid User", Toast.LENGTH_LONG).show();

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

                    nname.setText(req[0]);
                    nidentity.setText(req[1]);
                    nnation.setText(req[2]);
                    nrelation.setText(req[3]);
                    nbirth.setText(req[4]);
                    nocc.setText(req[5]);
                    mobile.setText(req[6]);
                }else {
                    Toast.makeText(Nominee_details.this, "No data available", Toast.LENGTH_LONG).show();
                }
            }


        }*/
        //}
    }
}
