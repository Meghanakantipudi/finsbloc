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

/**
 * Created by MEGHANA on 07-06-2017.
 */

public class Hospital_Login extends Activity{
    EditText l_hid, l_pwd;
    Button login;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_login);
        l_hid = (EditText) findViewById(R.id.l_hid);
        l_pwd = (EditText) findViewById(R.id.l_hpwd);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Hospital_Login.this, Hospital_patient.class);
                startActivity(in);
                /*String l_hid1 = l_hid.getText().toString().trim();
                String l_pwd1 = l_pwd.getText().toString().trim();
                try {
                    String url = ConnectionUtil.URL + "Servlet_h_login?l_hid=" + l_hid1 + "&l_hpwd=" + l_pwd1;
                    System.out.println(url);
                    GetXMLTask task = new GetXMLTask();
                    task.execute(new String[]{url});
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
                    status = status.trim();
                    // Toast.makeText(getBaseContext(), status, Toast.LENGTH_LONG).show();

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

                        Intent in = new Intent(Hospital_Login.this, Hospital_patient.class);
                        startActivity(in);
                        Toast.makeText(getBaseContext(), "Registered successfully ", Toast.LENGTH_LONG).show();


                    }
                }
            }*/
}

