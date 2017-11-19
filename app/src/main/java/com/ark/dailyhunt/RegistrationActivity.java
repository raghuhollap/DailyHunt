package com.ark.dailyhunt;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URI;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextName;
    private EditText editTextPassword;
    private EditText editTextEmail;
    private EditText editTextMobile;

    private Button buttonRegister;

    private static final String REGISTER_URL = "http://129.227.152.37/registration.php?";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextMobile = (EditText) findViewById(R.id.editTextMobile);


        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonRegister){
            registerUser();
        }
    }

    private void registerUser() {
        String name = editTextName.getText().toString().trim().toLowerCase();
        ///String username = editTextUsername.getText().toString().trim().toLowerCase();
        String password = editTextPassword.getText().toString().trim().toLowerCase();
        String email = editTextEmail.getText().toString().trim().toLowerCase();
        String mobile = editTextMobile.getText().toString().trim().toLowerCase();

        if (TextUtils.isEmpty(name)) {
            editTextName.setError("Please enter username");
            editTextName.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            editTextEmail.setError("Please enter your email");
            editTextEmail.requestFocus();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Enter a valid email");
            editTextEmail.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError("Enter a password");
            editTextPassword.requestFocus();
            return;
        }

        register(name,password,email,mobile);
    }

    private void register(final String name, final String password, final String email, final String mobile) {
        // String urlSuffix = "?name="+name+"&username="+username+"&password="+password+"&email="+email+"&mobile="+mobile;
        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {


            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                Toast.makeText(RegistrationActivity.this, "Data Submit Successfully", Toast.LENGTH_LONG).show();

            }

            @Override
            protected String doInBackground(String... params) {
                String s = params[0];
                //System.out.println("I am doInBackground");
                // System.out.println(" I am s "+s);
                // System.out.println(" I am name "+name);
                Log.i("Activity"," I am name "+name);
                Log.i("Activity"," I am password "+password);
                Log.i("Activity"," I am email "+email);
                Log.i("Activity"," I am mobile "+mobile);
                try{
                    String data  = URLEncoder.encode("name", "UTF-8") + "=" +
                            URLEncoder.encode(name, "UTF-8");
                    data += "&" + URLEncoder.encode("password", "UTF-8") + "=" +
                            URLEncoder.encode(password, "UTF-8");
                    data += "&" + URLEncoder.encode("email", "UTF-8") + "=" +
                            URLEncoder.encode(email, "UTF-8");
                    data += "&" + URLEncoder.encode("mobile", "UTF-8") + "=" +
                            URLEncoder.encode(mobile, "UTF-8");


                    URL url = new URL(REGISTER_URL);
                    URLConnection conn = url.openConnection();

                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                    wr.write( data );
                    wr.flush();

                    BufferedReader reader = new BufferedReader(new
                            InputStreamReader(conn.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    // Read Server Response
                    while((line = reader.readLine()) != null) {
                        sb.append(line);
                        break;
                    }

                    return sb.toString();
                } catch(Exception e){
                    return new String("Exception: " + e.getMessage());
                }
            }
        }

        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        sendPostReqAsyncTask.execute(name, email, password, mobile);
    }
}
