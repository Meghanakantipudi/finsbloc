package com.example.meghana.ui;

/**
 * Created by MEGHANA on 09-06-2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
 * Created by SRI on 04-06-2017.
 */

public class LoginNext extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        String id = i.getStringExtra("id");
        System.out.println(id);
        Toast.makeText(getBaseContext(), "Valid User", Toast.LENGTH_LONG).show();
        Intent i1=new Intent(getBaseContext(),Mainpage.class);
        startActivity(i1);
        /*try {

            //Toast.makeText(getBaseContext(), gen, Toast.LENGTH_LONG).show();
            String url = ConnectionUtil.URL + "LoginNext?aadharno="+id;
            System.out.println();
            LoginNext.GetXMLTask task = new LoginNext.GetXMLTask();
            task.execute(new String[]{url});
            System.out.println(url);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
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
            String status = output;
            status = status.trim();
            System.out.println(status);

            Toast.makeText(getBaseContext(), status, Toast.LENGTH_LONG).show();
            if (status.equals("exception")) {

                Toast.makeText(getBaseContext(), "Some problem Occured at the server", Toast.LENGTH_LONG).show();
                Intent i=new Intent(getBaseContext(),Mainpage.class);
                startActivity(i);
            }
            else if (status.equals("Unsuccessful")) {

                Toast.makeText(getBaseContext(), "No such user available", Toast.LENGTH_LONG).show();
                Intent i=new Intent(getBaseContext(),Mainpage.class);
                startActivity(i);
            } else if (status.equals("successfully")) {

                Toast.makeText(getBaseContext(), "Valid User", Toast.LENGTH_LONG).show();
                Intent i=new Intent(getBaseContext(),Mainpage.class);
                startActivity(i);
            }

        }
    }*/
}

