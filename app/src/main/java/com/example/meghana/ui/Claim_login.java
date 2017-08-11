package com.example.meghana.ui;

/**
 * Created by MEGHANA on 09-06-2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Claim_login extends Activity {
    EditText epolicy, epass;
    Button login;
    TextView policy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claim_login);
        epolicy = (EditText)findViewById(R.id.epolicyno);
        epass = (EditText)findViewById(R.id.epass);
        login = (Button)findViewById(R.id.submit);
        policy = (TextView)findViewById(R.id.tpolicyno);
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String policy_no = epolicy.getText().toString();
                String password = epass.getText().toString();
                Toast.makeText(getBaseContext(), "Valid User", Toast.LENGTH_LONG).show();
                Toast.makeText(getBaseContext(), "Your Details will be updated soon", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Claim_login.this, Buttons.class);
                //intent.putExtra("id", pwd);
                startActivity(intent);
                /*try {
                    //Toast.makeText(getBaseContext(), gen, Toast.LENGTH_LONG).show();
                    String url = ConnectionUtil.URL + "Formlog?Policy_no="+policy_no+"&Password="+password;
                    System.out.println();
                    Claim_login.GetXMLTask task = new Claim_login.GetXMLTask();
                    task.execute(new String[]{url});
                    System.out.println(url);
                }
                catch (Exception e) {
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
            String status = output;
            status = status.trim();
            Toast.makeText(getBaseContext(), status, Toast.LENGTH_LONG).show();
            if (status.equals("exception")) {
                Toast.makeText(getBaseContext(), "Some problem Occured at the server", Toast.LENGTH_LONG).show();
            } else if (status.equals("Unsuccessful")) {
                Toast.makeText(getBaseContext(), "Invalid Username/Password, Pls try again", Toast.LENGTH_LONG).show();
            }/* else if (status.equals("sucessfully")) {

                Toast.makeText(getBaseContext(), "Valid User", Toast.LENGTH_LONG).show();

            }*/
            /*else  {
                JSONObject obj = null;

                String pwd = status;
                //Log.i("json_result", result[1]);
                try {
                    obj = new JSONObject(status);
                    pwd = obj.getJSONObject("result").getString("message");

                    Log.i("json_pwd", pwd);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(Claim_login.this, LoginNext.class);
                intent.putExtra("id", pwd);
                startActivity(intent);
                Toast.makeText(getBaseContext(),pwd, Toast.LENGTH_LONG).show();
                policy.setText(pwd);
                policy.setVisibility(View.VISIBLE);

            }
        }
    }*/
}
