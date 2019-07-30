package com.example.rofinochungajr.museuonline;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.rofinochungajr.museuonline.database.DataBaseOpenHelper;
import com.example.rofinochungajr.museuonline.domain.model.Especie;
import com.example.rofinochungajr.museuonline.domain.model.Genero;
import com.example.rofinochungajr.museuonline.domain.model.TipoUtilizador;
import com.example.rofinochungajr.museuonline.domain.repository.EspecieRepository;
import com.example.rofinochungajr.museuonline.domain.repository.TipoUtilizadorRepository;

public class FormEspecieActivity extends AppCompatActivity {

    private EditText editTextNomeEspecie;
    private EditText editTextNomeComum;
    private Spinner spinnerGenero;
    private EditText editTextCoordenadas;
    private EditText editTextHabitat;
    private EditText editTextNotas;
    private EditText editTextCodigo;
    private EditText editTextValidacao;

    private TipoUtilizadorRepository utilizadorRepository;
    private TipoUtilizador utilizador;
    private Especie especie;
    private EspecieRepository especieRepository;
    private SQLiteDatabase connection;
    private DataBaseOpenHelper dataBaseOpenHelper;
    private ConstraintLayout constraintLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_especie);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       // FloatingActionButton fab = findViewById(R.id.fab);

        editTextNomeEspecie = (EditText) findViewById(R.id.editTextNomeEspecie);
        editTextNomeComum = (EditText) findViewById(R.id.editTextNomeComum);
        spinnerGenero = (Spinner) findViewById(R.id.spinnerGenero);
        editTextCoordenadas = (EditText) findViewById(R.id.editTextCoordenadas);
        editTextHabitat = (EditText) findViewById(R.id.editTextHabitat);
        editTextNotas = (EditText) findViewById(R.id.editTextNotas);
        editTextCodigo = (EditText) findViewById(R.id.editTextCodigo);
        editTextValidacao = (EditText) findViewById(R.id.editTextValidacao);


        //constraintLayout=(ConstraintLayout)findViewById(R.id.constraintFormEspecie);



        createConnectionDB();
      /*  fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action ===" + editTextNomeEspecie.getText(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    }


    public boolean isEmpty(String value){
        boolean result=(TextUtils.isEmpty(value) || value.trim().isEmpty());

        return result;

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

                Intent intent=new Intent(FormEspecieActivity.this,IdentificaoActivity.class);
                startActivity(intent);
                //finish();
                //Toast.makeText(this,"Ok selecoonado",Toast.LENGTH_SHORT).show();
            }break;
            case R.id.action_cancelar:{
                Toast.makeText(this,"Cancelar selecoonado",Toast.LENGTH_SHORT).show();
            }break;

            case R.id.action_save:{
                confirm();
            }

            default:{
                System.out.println("Invalid Option");
            }break;

        }

        return super.onOptionsItemSelected(item);
    }



    private void createConnectionDB(){
        try{
            dataBaseOpenHelper=new DataBaseOpenHelper(this);
            connection=dataBaseOpenHelper.getWritableDatabase();

            //Snackbar.make(constraintLayout, R.string.msg_sucess_conectionDB, Snackbar.LENGTH_SHORT).setAction("ok",null).show();
            utilizadorRepository=new TipoUtilizadorRepository(connection);
            especieRepository=new EspecieRepository(connection);
        }catch (SQLException ex){
            AlertDialog.Builder dlg=new AlertDialog.Builder(this);

            dlg.setTitle(R.string.title_aviso);
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton(R.string.msg_ok,null);
        }
    }
    private void validation(){

        String nomeEspecie=editTextNomeEspecie.getText().toString();
        String nomeComum=editTextNomeComum.getText().toString();;
        String habitat=editTextHabitat.getText().toString();
        String coordenadas=editTextCoordenadas.getText().toString();
        String notas=editTextNotas.getText().toString();
       // String detalhes=editTextDetalhes.getText().toString();
        String codigo=editTextCodigo.getText().toString();
        String validacao=editTextValidacao.getText().toString();
        //String dataCriacao;
        //int genero=editTextGenero.getText().toString();
        int idTipoUtilizador=7;

      //  utilizador.setIdTipoUtilizador(56);
        especie.setNomeEspecie("Ola");
        especie.setNomeComum("Salama");
        especie.setHabitat("Tudo bem");
        especie.setCoordenadas("Ola");
        especie.setNotas("tchau");
        especie.setCodigo("dgdgd");
        especie.setValidacao("tetet");


        utilizador.setTipoUtilizador("teste");
        //utilizador.setIdUtilizador();

    }

    private void confirm(){

        utilizador=new TipoUtilizador();
        especie=new Especie();
        validation();
        try {

            especieRepository.insert(especie);
            //utilizadorRepository.insert(utilizador);
            finish();

        }catch (SQLException ex){
        AlertDialog.Builder dlg=new AlertDialog.Builder(this);

        dlg.setTitle(R.string.title_aviso);
        dlg.setMessage(ex.getMessage());
        dlg.setNeutralButton(R.string.msg_ok,null);

    }
    }
}
