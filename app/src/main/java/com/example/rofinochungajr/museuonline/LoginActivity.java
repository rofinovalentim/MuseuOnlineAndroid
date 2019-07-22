package com.example.rofinochungajr.museuonline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    private boolean validLogin(String email, String password){

        return  true;
    }

    private boolean isValidEmail(String email){
        boolean result= Patterns.EMAIL_ADDRESS.matcher(email).matches();

        return result;
    }

}
