package com.example.rofinochungajr.museuonline;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rofinochungajr.museuonline.domain.model.TipoUtilizador;
import com.example.rofinochungajr.museuonline.domain.model.Utilizador;
import com.example.rofinochungajr.museuonline.domain.repository.TipoUtilizadorRepository;
import com.example.rofinochungajr.museuonline.domain.repository.UtilizadorRepository;
import com.example.rofinochungajr.museuonline.staticsmethods.StaticsMethods;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextNomeCompleto;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextConfirmPass;
    private Button buttonRegisterUser;
    private Utilizador utilizador;
    private TipoUtilizador tipoUtilizador;
    private TipoUtilizadorRepository tipoUtilizadorRepository;
    private UtilizadorRepository utilizadorRepository;
    private SQLiteDatabase connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        editTextNomeCompleto = (EditText) findViewById(R.id.editTextNomeCompleto);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextConfirmPass = (EditText) findViewById(R.id.editTextConfirmarPassword);
        buttonRegisterUser = (Button) findViewById(R.id.buttonRegistarUser);

        connection=StaticsMethods.createConnectionDB(this);

        utilizadorRepository=new UtilizadorRepository(connection);


        buttonRegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //validation();
                confirm();

            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    private boolean confirm() {

        utilizador = new Utilizador();
        if (validation() == false) {

            try {

                //utilizadorRepository = new UtilizadorRepository(StaticsMethods.createConnectionDB(this));
                utilizadorRepository.insert(utilizador);
                Toast.makeText(this, "Registado com sucesso", Toast.LENGTH_SHORT).show();

                return true;
            } catch (SQLException ex) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setTitle(R.string.title_aviso);
                dlg.setMessage(ex.getMessage());
                dlg.setNeutralButton(R.string.msg_ok, null);
                return false;
            }
        }
        return false;
    }


    private boolean validation() {
        boolean result = false;

        String nomeCompleto = editTextNomeCompleto.getText().toString();
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        String confirmPassword = editTextConfirmPass.getText().toString();

        tipoUtilizadorRepository = new TipoUtilizadorRepository(StaticsMethods.createConnectionDB(this));
        utilizador.setTipoUtilizador(tipoUtilizadorRepository.getTipoUtilizador(7));
        utilizador.setPassword(password);
        utilizador.setEmail(email);

        if (result = StaticsMethods.isEmpty(nomeCompleto)) {
            editTextNomeCompleto.requestFocus();
        } else {

            if (result = StaticsMethods.isEmpty(email) || StaticsMethods.isValidEmail(email) == false) {
                editTextEmail.requestFocus();
                Toast.makeText(this, "Campo Email Vazio ou Email Invalido", Toast.LENGTH_LONG).show();

            } else {

                Utilizador exist = utilizadorRepository.getUtilizadorByEmail(email);

                if (exist != null) {
                    result=true;
                    editTextEmail.requestFocus();
                    Toast.makeText(this, "Ja existe uma Conta com esse Email", Toast.LENGTH_LONG).show();
                }
            }
        }
        if (result = StaticsMethods.isEmpty(password)) {
            editTextPassword.requestFocus();
        } else {
            if (result = StaticsMethods.isEmpty(confirmPassword) || !password.equals(confirmPassword)) {
                editTextConfirmPass.requestFocus();
            }
        }
        return result;
    }
}

