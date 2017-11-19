package com.ark.dailyhunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AppWelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton;
    private Button singUpButton;
    private Button skipButton;
    private Intent firstPageIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_welcome);
        loginButton = (Button) findViewById(R.id.login_button);
        singUpButton = (Button) findViewById(R.id.signup_button);
        skipButton = (Button) findViewById(R.id.skip_button);
        loginButton.setOnClickListener(this);
        singUpButton.setOnClickListener(this);
        skipButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_button:
                firstPageIntent = new Intent(this, LocationPickerActivity.class);
                startActivity(firstPageIntent);
                break;
            case R.id.signup_button:
                firstPageIntent = new Intent(this, RegistrationActivity.class);
                startActivity(firstPageIntent);
                break;
            case R.id.skip_button:
                firstPageIntent = new Intent(this, LocationPickerActivity.class);
                startActivity(firstPageIntent);
                break;
        }
    }
}
