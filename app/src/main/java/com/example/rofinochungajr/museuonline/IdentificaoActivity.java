package com.example.rofinochungajr.museuonline;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.rofinochungajr.museuonline.database.DataBaseOpenHelper;
import com.example.rofinochungajr.museuonline.domain.model.Distrito;
import com.example.rofinochungajr.museuonline.domain.model.Genero;
import com.example.rofinochungajr.museuonline.domain.model.Provincia;
import com.example.rofinochungajr.museuonline.domain.model.Regiao;
import com.example.rofinochungajr.museuonline.domain.repository.DistritoRepository;
import com.example.rofinochungajr.museuonline.domain.repository.EspecieRepository;
import com.example.rofinochungajr.museuonline.domain.repository.GeneroRepository;
import com.example.rofinochungajr.museuonline.domain.repository.ProvinciaRepository;
import com.example.rofinochungajr.museuonline.domain.repository.RegiaoRepository;
import com.example.rofinochungajr.museuonline.domain.repository.TipoUtilizadorRepository;
import com.example.rofinochungajr.museuonline.staticsmethods.StaticsMethods;

import java.util.ArrayList;
import java.util.List;

public class IdentificaoActivity extends AppCompatActivity {

    private Spinner spinnerProvincia;
    private Spinner spinnerDistrito;
    private Spinner spinnerRegiao;
    private DataBaseOpenHelper dataBaseOpenHelper;
    private RegiaoRepository regiaoRepository;
    private ProvinciaRepository provinciaRepository;
    private DistritoRepository distritoRepository;
    private SQLiteDatabase connection;
    private Provincia provincia;
    private Distrito distrito;
    private Regiao regiao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identificao);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinnerProvincia=(Spinner)findViewById(R.id.spinnerProvincia);
        spinnerDistrito=(Spinner)findViewById(R.id.spinnerDistrito);
        spinnerRegiao=(Spinner)findViewById(R.id.spinnerRegiao);

        connection=StaticsMethods.createConnectionDB(this);

        provinciaRepository=new ProvinciaRepository(connection);
        distritoRepository=new DistritoRepository(connection);
        regiaoRepository=new RegiaoRepository(connection);
        //createConnectionDB();

        List<Provincia> list=provinciaRepository.getAll();
        ArrayAdapter<Provincia> adapter=new ArrayAdapter<Provincia>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProvincia.setAdapter(adapter);

        spinnerProvincia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                provincia= (Provincia) parent.getSelectedItem();//.getItemAtPosition(position);
           //    Toast.makeText(IdentificaoActivity.this, "Selected: "+provincia,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Toast.makeText(IdentificaoActivity.this, "Selected: "+provincia,Toast.LENGTH_SHORT).show();

        List<Distrito> distritoList=distritoRepository.getAll();
        ArrayAdapter<Distrito> distritoArrayAdapter=new ArrayAdapter<Distrito>(this,android.R.layout.simple_spinner_item,distritoList);
        distritoArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDistrito.setAdapter(distritoArrayAdapter);

        spinnerDistrito.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                distrito= (Distrito) parent.getItemAtPosition(position);
                Toast.makeText(IdentificaoActivity.this, "Selected: "+distrito,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        List<Regiao> regiaoList=regiaoRepository.getAll();
        ArrayAdapter<Regiao> regiaoAdapter =new ArrayAdapter<Regiao>(this,android.R.layout.simple_spinner_item,regiaoList);
        regiaoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRegiao.setAdapter(regiaoAdapter);

        spinnerRegiao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                regiao= (Regiao) parent.getItemAtPosition(position);
                Toast.makeText(IdentificaoActivity.this, "Selected: "+regiao,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


       /* FloatingActionButton fab = findViewById(R.id.fab);
       fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    private void createConnectionDB(){
        try{
            dataBaseOpenHelper=new DataBaseOpenHelper(this);
            connection=dataBaseOpenHelper.getWritableDatabase();

            //Snackbar.make(constraintLayout, R.string.msg_sucess_conectionDB, Snackbar.LENGTH_SHORT).setAction("ok",null).show();
           provinciaRepository=new ProvinciaRepository(connection);
           distritoRepository=new DistritoRepository(connection);
        }catch (SQLException ex){
            AlertDialog.Builder dlg=new AlertDialog.Builder(this);

            dlg.setTitle(R.string.title_aviso);
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton(R.string.msg_ok,null);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.nav_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {   //quando selecionamos um dos itens do menu criado

        int id=item.getItemId();

        switch (id){
            case R.id.action_next:{
                Intent intent=new Intent(IdentificaoActivity.this,MultimidiaActivity.class);
                startActivity(intent);
            }break;
            case R.id.action_cancelar:{
                Toast.makeText(this,"Cancelar selecoonado",Toast.LENGTH_SHORT).show();
            }break;

            case R.id.action_save:{

            }
        }

        return super.onOptionsItemSelected(item);
    }





}
