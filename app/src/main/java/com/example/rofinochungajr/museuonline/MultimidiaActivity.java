package com.example.rofinochungajr.museuonline;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MultimidiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimidia);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
/*
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {   //quando selecionamos um dos itens do menu criado

        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:{
                finish();
                break;
            }
            case R.id.action_next: {
              /*  Intent intent = new Intent(FormEspecieActivity.this, IdentificaoActivity.class);
                startActivity(intent);
                */
                //finish();
                //Toast.makeText(this,"Ok selecoonado",Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.action_cancelar: {
                finish();
                //Toast.makeText(this, "Cancelar selecoonado", Toast.LENGTH_SHORT).show();
            }
            break;

            case R.id.action_save: {
                //confirm();
            }break;

            default: {
                System.out.println("Invalid Option");
            }
            break;

        }

        return super.onOptionsItemSelected(item);
    }




}
