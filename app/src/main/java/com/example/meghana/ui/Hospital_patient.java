package com.example.meghana.ui;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
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
import java.util.Calendar;

/**
 * Created by MEGHANA on 07-06-2017.
 */

public class Hospital_patient extends Activity {
    EditText pid, p_rsn, p_dt_tm;
    Button sb;
    int mYear, mMonth, mDay, hour,minute;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_patient);
        pid = (EditText) findViewById(R.id.pid);
        p_rsn = (EditText) findViewById(R.id.p_death);
        p_dt_tm = (EditText) findViewById(R.id.d_p_death);
        sb = (Button) findViewById(R.id.submit);
        p_dt_tm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentDate=Calendar.getInstance();
                mYear=mcurrentDate.get(Calendar.YEAR);
                mMonth=mcurrentDate.get(Calendar.MONTH);
                mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(Hospital_patient.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                        p_dt_tm.setText(selectedday+"/"+(selectedmonth+1)+"/"+selectedyear);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.setTitle("Select date");
                mDatePicker.show();
            }
        });
        sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pid1 = pid.getText().toString().trim();
                String p_rsn1 = p_rsn.getText().toString().trim();
                String p_dt_tm1 = p_dt_tm.getText().toString().trim();
                Toast.makeText(getBaseContext(), "Inserted successfully ", Toast.LENGTH_LONG).show();
                Intent in = new Intent(Hospital_patient.this, Buttons.class);
                startActivity(in);
                /*try {
                        String url = ConnectionUtil.URL + "Servlet_h_pat?pid=" + pid1 + "&p_rsn=" + p_rsn1 + "&p_dt_tm=" + p_dt_tm1;
                        System.out.println(url);
                        Hospital_patient.GetXMLTask task = new Hospital_patient.GetXMLTask();
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

            if(status.equals("exception"))
            {
                Toast.makeText(getBaseContext(), "Some problem Occured at the server", Toast.LENGTH_LONG).show();
            }
            else if(status.equals("Registration unsuccessful"))
            {
                Toast.makeText(getBaseContext(), "Invalid Username/Password, Pls try again", Toast.LENGTH_LONG).show();
            }
            else if(status.equals("Registration Successful"))
            {

                //Intent in = new Intent(Hospital_Registration.this, Hospital_Login.class);
                //startActivity(in);
                Toast.makeText(getBaseContext(), "Registered successfully ", Toast.LENGTH_LONG).show();


            }
        }
    }*/
}
