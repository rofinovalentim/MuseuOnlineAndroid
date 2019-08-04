package com.example.rofinochungajr.museuonline;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rofinochungajr.museuonline.domain.model.Utilizador;
import com.example.rofinochungajr.museuonline.domain.repository.UtilizadorRepository;
import com.example.rofinochungajr.museuonline.staticsmethods.StaticsMethods;

public class LoginActivity extends AppCompatActivity {



    private EditText editTextEmailAdress;
    private EditText editTextPassword;
    private Button btnLogin;
    private TextView btnCreateAccout;
    private TextView forgetPassword;
    private SQLiteDatabase connection;
    private Utilizador utilizador;
    private UtilizadorRepository utilizadorRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        editTextEmailAdress = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnCreateAccout = (TextView) findViewById(R.id.btnCriarConta);

        connection = StaticsMethods.createConnectionDB(this);
        utilizadorRepository = new UtilizadorRepository(connection);

        btnCreateAccout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String email = editTextEmailAdress.getText().toString();
                String password = editTextPassword.getText().toString();



                /*Intent intent = new Intent(LoginActivity.this, FormEspecieActivity.class);
                startActivity(intent);*/

                if (!StaticsMethods.isValidEmail((editTextEmailAdress.getText().toString())) || StaticsMethods.isEmpty(email)) {
                    editTextEmailAdress.requestFocus();
                    Snackbar.make(view, "Campo vazio ou email Invalido ", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                } else {
                    if (StaticsMethods.isEmpty(password)) {
                        editTextPassword.requestFocus();
                        Snackbar.make(view, "Campo do palavra-passe VAZIO ", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    } else {
                        utilizador = utilizadorRepository.getUtilizadorByEmail(email);
                        if (utilizador == null) {
                            Snackbar.make(view, "Email incorrecto", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                        } else {
                            if (utilizador.getPassword().equals(password)) {
                                Snackbar.make(view, "Login efectuado com sucesso", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                                startActivity(intent);
                            } else {
                                Snackbar.make(view, "Palavra passe incorecta", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                            }
                        }

                    }
                }
              /*  Snackbar.make(view, "Replace with your own action ==" + editTextEmailAdress.getText().toString(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });
        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

}
