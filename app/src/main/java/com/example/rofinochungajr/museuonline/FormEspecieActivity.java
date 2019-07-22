package com.example.rofinochungajr.museuonline;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.zip.Inflater;

public class FormEspecieActivity extends AppCompatActivity {

    private EditText editTextNomeEspecie;
    private EditText editTextNomeComum;
    private EditText editTextGenero;
    private EditText editTextCoordenadas;
    private EditText editTextHabitat;
    private EditText editTextNotas;
    private EditText editTextCodigo;
    private EditText editTextValidacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_especie);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);

        editTextNomeEspecie = (EditText) findViewById(R.id.editTextNomeEspecie);
        editTextNomeComum = (EditText) findViewById(R.id.editTextNomeComum);
        editTextGenero = (EditText) findViewById(R.id.editTextGenero);
        editTextCoordenadas = (EditText) findViewById(R.id.editTextCoordenadas);
        editTextHabitat = (EditText) findViewById(R.id.editTextHabitat);
        editTextNotas = (EditText) findViewById(R.id.editTextNotas);
        editTextCodigo = (EditText) findViewById(R.id.editTextCodigo);
        editTextValidacao = (EditText) findViewById(R.id.editTextValidacao);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action ===" + editTextNomeEspecie.getText(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    public boolean isEmpty(String value){
        boolean result=(TextUtils.isEmpty(value) || value.trim().isEmpty());

        return result;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_form_especie, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {   //quando selecionamos um dos itens do menu criado

        int id=item.getItemId();

        switch (id){
            case R.id.action_ok:{
                Toast.makeText(this,"Ok selecoonado",Toast.LENGTH_SHORT).show();
            }break;
            case R.id.action_cancelar:{
                Toast.makeText(this,"Cancelar selecoonado",Toast.LENGTH_SHORT).show();
            }break;

            default:{
                System.out.println("Invalid Option");
            }break;

        }

        return super.onOptionsItemSelected(item);
    }
}
