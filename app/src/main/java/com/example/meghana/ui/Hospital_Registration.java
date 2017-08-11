package com.example.meghana.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

import static android.R.attr.id;

/**
 * Created by MEGHANA on 07-06-2017.
 */

public class Hospital_Registration extends Activity {
    EditText h_id, name, address, password;
    Button reg_button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_registration);
        h_id = (EditText) findViewById(R.id.h_id);
        name = (EditText) findViewById(R.id.name);
        address = (EditText) findViewById(R.id.address);
        password = (EditText) findViewById(R.id.password);
        reg_button = (Button) findViewById(R.id.reg_button);
        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hid1 = h_id.getText().toString().trim();
                String hname1 = name.getText().toString().trim();
                String hadd1 = address.getText().toString().trim();
                String hpwd1 = password.getText().toString().trim();
                Toast.makeText(getBaseContext(), "Registered successfully ", Toast.LENGTH_LONG).show();
                Intent in = new Intent(Hospital_Registration.this, Hospital_Login.class);
                startActivity(in);

                    /*try {
                        //String url1 = ConnectionUtil.URL;
                        //System.out.println(url1);
                        String url = ConnectionUtil.URL+"Servlethreg?h_id="+hid1+"&name="+hname1+"&address="+hadd1+"&password="+hpwd1;
                        System.out.println(url);
                        GetXMLTask task = new GetXMLTask();
                        task.execute(new String[]{url});
                        //Intent in = new Intent(Hospital_Registration.this, Hospital_Login.class);
                        //startActivity(in);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }*/
            }

        });

    }

    /*public class GetXMLTask extends AsyncTask<String, Void, String> {

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
            status = status.trim();
           // Toast.makeText(getBaseContext(), status, Toast.LENGTH_LONG).show();

            /*if(status.equals("exception"))
            {
                Toast.makeText(getBaseContext(), "Some problem Occured at the server", Toast.LENGTH_LONG).show();
            }
            else if(status.equals("Registration unsuccessful"))
            {
                Toast.makeText(getBaseContext(), "Invalid Username/Password, Pls try again", Toast.LENGTH_LONG).show();
            }
            else if(status.equals("Registration Successful"))
            {

                Intent in = new Intent(Hospital_Registration.this, Hospital_Login.class);
                startActivity(in);
                Toast.makeText(getBaseContext(), "Registered successfully ", Toast.LENGTH_LONG).show();


            }
        }
    }*/
}