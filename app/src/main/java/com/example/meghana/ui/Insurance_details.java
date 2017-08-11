package com.example.meghana.ui;

/**
 * Created by MEGHANA on 09-06-2017.
 */

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import java.util.Calendar;

public class Insurance_details extends AppCompatActivity {
    EditText insu_name, aadhar, nationality, edit, edit1, occupation, nom_name,nom_aadhar, nom_relation, nom_nationality,nom_edit, nom_occ, nom_phone, cert_no,policy_no, password;
    Button submit;
    RadioGroup rg;
    String place;
    int mYear,mMonth,mDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance_details);
        insu_name = (EditText)findViewById(R.id.name_insu);
        aadhar = (EditText)findViewById(R.id.aadharno);
        nationality = (EditText)findViewById(R.id.nationality);
        edit = (EditText)findViewById(R.id.edit);
        edit1 = (EditText)findViewById(R.id.edit1);
        occupation =(EditText)findViewById(R.id.eoccupation);
        nom_name = (EditText)findViewById(R.id.enom_name);
        nom_aadhar = (EditText)findViewById(R.id.enom_adharno);
        nom_relation = (EditText)findViewById(R.id.enom_relation);
        nom_nationality = (EditText)findViewById(R.id.enom_nationality);
        nom_edit = (EditText)findViewById(R.id.nom_edit);
        nom_occ = (EditText)findViewById(R.id.enom_occ);
        nom_phone = (EditText)findViewById(R.id.enom_phone);
        cert_no = (EditText)findViewById(R.id.certi_no);
        policy_no = (EditText)findViewById(R.id.epolicy_no);
        password = (EditText) findViewById(R.id.epass);
        submit = (Button)findViewById(R.id.submit);
        rg=(RadioGroup)findViewById(R.id.select);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes  int i) {
                final String value=((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();

                place=value;
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //To show current date in the datepicker
                Calendar mcurrentDate=Calendar.getInstance();
                mYear=mcurrentDate.get(Calendar.YEAR);
                mMonth=mcurrentDate.get(Calendar.MONTH);
                mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(Insurance_details.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                        edit.setText(selectedday+"/"+(selectedmonth+1)+"/"+selectedyear);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.setTitle("Select date");
                mDatePicker.show();
            }
        });
        edit1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //To show current date in the datepicker
                Calendar mcurrentDate=Calendar.getInstance();
                mYear=mcurrentDate.get(Calendar.YEAR);
                mMonth=mcurrentDate.get(Calendar.MONTH);
                mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(Insurance_details.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                        edit1.setText(selectedday+"/"+(selectedmonth+1)+"/"+selectedyear);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.setTitle("Select date");
                mDatePicker.show();
            }
        });
        nom_edit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //To show current date in the datepicker
                Calendar mcurrentDate=Calendar.getInstance();
                mYear=mcurrentDate.get(Calendar.YEAR);
                mMonth=mcurrentDate.get(Calendar.MONTH);
                mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(Insurance_details.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                        nom_edit.setText(selectedday+"/"+(selectedmonth+1)+"/"+selectedyear);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.setTitle("Select date");
                mDatePicker.show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = insu_name.getText().toString().trim();
                String aadhar_no = aadhar.getText().toString().trim();
                String nation = nationality.getText().toString().trim();
                String birthday = edit.getText().toString().trim();
                String deathday = edit1.getText().toString().trim();
                String ocupation = occupation.getText().toString().trim();
                String n_name = nom_name.getText().toString().trim();
                String n_aadhar = nom_aadhar.getText().toString().trim();
                String n_relation = nom_relation.getText().toString().trim();
                String n_nationality = nom_nationality.getText().toString().trim();
                String n_birthday = nom_edit.getText().toString().trim();
                String n_occupation = nom_occ.getText().toString().trim();
                String n_mobileno = nom_phone.getText().toString().trim();
                String n_certi = cert_no.getText().toString().trim();
                String n_policy = policy_no.getText().toString().trim();
                String n_pass = password.getText().toString().trim();
                Toast.makeText(getBaseContext(), "Registered successfully ", Toast.LENGTH_LONG).show();
                Intent i=new Intent(getBaseContext(),Mainpage.class);
                startActivity(i);
                /*try {

                    //Toast.makeText(getBaseContext(), gen, Toast.LENGTH_LONG).show();
                    String url = ConnectionUtil.URL + "Insurance?Iname="+name+"&Iaadharno="+aadhar_no+"&Ination="+nation+"&Ibirth="+birthday+"&Ideath="+deathday+"&Iplace="+place+"&Ioccupation="+ocupation+"&n_name="+n_name+"&n_aadhar="+n_aadhar+"&n_relation="+n_relation+"&n_nation="+n_nationality+"&nbirth="+n_birthday+"&noccupation="+n_occupation+"&mobile=" + n_mobileno+"&certificateno="+n_certi+"&policyno="+n_policy+"&password="+n_pass;
                    System.out.println();
                    Toast.makeText(getBaseContext(), "hbfjdsjnsjk", Toast.LENGTH_LONG).show();
                    Insurance_details.GetXMLTask task = new Insurance_details.GetXMLTask();
                    task.execute(new String[]{url});
                    System.out.print(url);
                }
                catch(Exception e){
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
            //status = status.trim();
            Toast.makeText(getBaseContext(), status, Toast.LENGTH_LONG).show();
            if(status.equals("exception"))
            {
                Toast.makeText(getBaseContext(), "Some problem Occured at the server", Toast.LENGTH_LONG).show();
            }
            else if(status.equals("Registration unsuccessful"))
            {
                Toast.makeText(getBaseContext(), "Invalid Username/Password, Pls try again", Toast.LENGTH_LONG).show();
                Intent i=new Intent(getBaseContext(),Mainpage.class);
                startActivity(i);
            }
            else if(status.equals("Registration Successful"))
            {


                Toast.makeText(getBaseContext(), "Registered successfully ", Toast.LENGTH_LONG).show();
                Intent i=new Intent(getBaseContext(),Mainpage.class);
                startActivity(i);
            }
            else if(status.equals("Details are not valid")) {
                Toast.makeText(getBaseContext(), "Details are not valid", Toast.LENGTH_LONG).show();
                Intent i=new Intent(getBaseContext(),Mainpage.class);
                startActivity(i);
            }

        }
    }*/
}


