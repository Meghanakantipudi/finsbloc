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
 * Created by WINDOWS on 07-06-2017.
 */

public class State_health_login extends Activity {
    Button myButton;
    EditText eds1,eds2,eds3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.state_health_login);
        eds1 =(EditText) findViewById(R.id.ed);
        eds2 = (EditText) findViewById(R.id.loc);
        eds3 = (EditText) findViewById(R.id.pass);
        myButton = (Button) findViewById(R.id.but1);
        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent in = new Intent(State_health_login.this, Applications.class);
                startActivity(in);
                /*try {
                    String edss = eds1.getText().toString().trim();
                    String edloc = eds2.getText().toString().trim();
                    String edpass = eds3.getText().toString().trim();
                    String url = ConnectionUtil.URL + "Servlet_state_login?eds1=" + edss + "&eds2=" + edloc + "&eds3=" + edpass;
                    System.out.println(url);
                    State_health_login.GetXMLTask task = new State_health_login.GetXMLTask();
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

                Intent in = new Intent(State_health_login.this, Applications.class);
                startActivity(in);
                Toast.makeText(getBaseContext(), "Registered successfully ", Toast.LENGTH_LONG).show();


            }
        }
    }*/
}