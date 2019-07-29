package com.example.rofinochungajr.museuonline;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmailAdress;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmailAdress=(EditText) findViewById(R.id.editTextEmailAddress);
        editTextPassword=(EditText) findViewById(R.id.editTextPassword);


        Button button = findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             /*   Intent intent=new Intent(LoginActivity.this,FormEspecieActivity.class);
                startActivity(intent);*/

             if (isValidEmail(editTextEmailAdress.getText().toString())){
                 Snackbar.make(view, "Replace with your own action =="+editTextEmailAdress.getText().toString(), Snackbar.LENGTH_LONG)
                         .setAction("Action", null).show();
             }
               Snackbar.make(view, "Replace with your own action =="+editTextEmailAdress.getText().toString(), Snackbar.LENGTH_LONG)
                       .setAction("Action", null).show();
            }
        });
    }

    private boolean validaLogin(){


        return  true;
    }

    private boolean isValidEmail(String email){
        boolean result= Patterns.EMAIL_ADDRESS.matcher(email).matches();

        return result;
    }
}
