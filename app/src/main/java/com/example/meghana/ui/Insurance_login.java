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
import android.widget.EditText;
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

public class Insurance_login extends Activity {
    EditText ed1,ed2,ed3;
    Button b;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insurance_login);
        ed1 = (EditText) findViewById(R.id.edd);
        ed2 = (EditText) findViewById(R.id.loc);
        ed3 = (EditText) findViewById(R.id.pass);
        b = (Button) findViewById(R.id.buts);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Insurance_login.this,Nominee_ids.class);
                startActivity(i1);

                /*try {
                    String neds = ed1.getText().toString().trim();
                    String nedloc = ed2.getText().toString().trim();
                    String nedpass = ed3.getText().toString().trim();
                    String url = ConnectionUtil.URL + "Servlet_i_login?l_i_id=" + neds + "&l_i_pwd=" + nedpass;
                    System.out.println(url);
                    Insurance_login.GetXMLTask task = new Insurance_login.GetXMLTask();
                    Toast.makeText(getBaseContext(), "hbfjdsjnsjk", Toast.LENGTH_LONG).show();
                    task.execute(new String[]{url});
                    Toast.makeText(getBaseContext(), "hb", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }*/

            }
        });
    }
    /*class GetXMLTask extends AsyncTask<String, Void, String> {

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
            String status =output;
            //status = status.trim();
            Toast.makeText(getBaseContext(),status, Toast.LENGTH_LONG).show();

            if(status.equals("exception"))
            {
                Toast.makeText(getBaseContext(), "Some problem Occured at the server", Toast.LENGTH_LONG).show();
            }
            else if(status.equals("Unsuccessful"))
            {
                Toast.makeText(getBaseContext(), "Invalid Username/Password, Pls try again", Toast.LENGTH_LONG).show();
            }
            else if(status.equals("Successfully"))
            {

                Intent in = new Intent(Insurance_login.this, Nominee_ids.class);
                startActivity(in);
                Toast.makeText(getBaseContext(), "Registered successfully ", Toast.LENGTH_LONG).show();


            }*/
       // }
    //}
}