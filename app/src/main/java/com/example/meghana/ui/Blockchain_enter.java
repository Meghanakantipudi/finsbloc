package com.example.meghana.ui;

/**
 * Created by MEGHANA on 09-06-2017.
 */

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
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

public class Blockchain_enter extends AppCompatActivity {
    EditText s;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blockchain_enter);
        bt=(Button)findViewById(R.id.button);
        s=(EditText)findViewById(R.id.ed);
        final EditText e=(EditText)findViewById(R.id.pass);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=s.getText().toString();
                String str1=e.getText().toString();
                try {
                    String url = ConnectionUtil.URL +"hai?&ename="+str+"&epass="+str1;
                    // System.out.println(url);
                    //url = url.trim();
                    // url = url.replace(" ","%20");
                    Blockchain_enter.GetXMLTask task = new Blockchain_enter.GetXMLTask();
                    task.execute(new String[]{url});
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
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
            Toast.makeText(getBaseContext(), status, Toast.LENGTH_LONG).show();
            if (status.equals("exception")) {
                Toast.makeText(getBaseContext(), "Some problem Occured at the server", Toast.LENGTH_LONG).show();
            } else if (status.equals("unsuccess")) {
                Toast.makeText(getBaseContext(), "Invalid Username/Password, Pls try again", Toast.LENGTH_LONG).show();
            } else if (status.equals("sucessfully")) {

                Toast.makeText(getBaseContext(), "Valid User", Toast.LENGTH_LONG).show();

            }
        }
    }
}

