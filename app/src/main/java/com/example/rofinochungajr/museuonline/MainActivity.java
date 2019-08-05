package com.example.rofinochungajr.museuonline;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rofinochungajr.museuonline.adapters.EspecieAdapter;
import com.example.rofinochungajr.museuonline.database.DataBaseOpenHelper;
import com.example.rofinochungajr.museuonline.domain.model.Especie;
import com.example.rofinochungajr.museuonline.domain.model.LocalizacaoEspecie;
import com.example.rofinochungajr.museuonline.domain.model.MetodoDePreservacao;
import com.example.rofinochungajr.museuonline.domain.model.Pessoa;
import com.example.rofinochungajr.museuonline.domain.model.PreservacaoEspecie;
import com.example.rofinochungajr.museuonline.domain.model.Provincia;
import com.example.rofinochungajr.museuonline.domain.model.QuemEncontrou;
import com.example.rofinochungajr.museuonline.domain.model.QuemIdentificou;
import com.example.rofinochungajr.museuonline.domain.model.TipoUtilizador;
import com.example.rofinochungajr.museuonline.domain.model.Utilizador;
import com.example.rofinochungajr.museuonline.domain.repository.EspecieRepository;
import com.example.rofinochungajr.museuonline.domain.repository.LocalizacaoEspecieRepository;
import com.example.rofinochungajr.museuonline.domain.repository.MetodoPreservacaoRepository;
import com.example.rofinochungajr.museuonline.domain.repository.PessoaRepository;
import com.example.rofinochungajr.museuonline.domain.repository.PreservacaoEspecieRepository;
import com.example.rofinochungajr.museuonline.domain.repository.ProvinciaRepository;
import com.example.rofinochungajr.museuonline.domain.repository.QuemEncontrouRepository;
import com.example.rofinochungajr.museuonline.domain.repository.QuemIdentificouRepository;
import com.example.rofinochungajr.museuonline.domain.repository.TipoUtilizadorRepository;
import com.example.rofinochungajr.museuonline.domain.repository.UtilizadorRepository;
import com.example.rofinochungajr.museuonline.staticsmethods.StaticsMethods;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private SQLiteDatabase connection;
    private DataBaseOpenHelper dataBaseOpenHelper;
    private RecyclerView lstDados;
    private TextView textView;

    private EspecieAdapter especieAdapter;
    private EspecieRepository especieRepository;
    private TipoUtilizadorAdapter tipoUtilizadorAdapter;
    private TipoUtilizadorRepository tipoUtilizadorRepository;
    private ProvinciaRepository provinciaRepository;
    private LocalizacaoEspecieRepository localizacaoEspecieRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayUseLogoEnabled(true);

       // lstDados=(RecyclerView) findViewById(R.id.recicleViewMain);

        textView=(TextView) findViewById(R.id.list);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FormEspecieActivity.class);
                startActivity(intent);
               /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

        connection=StaticsMethods.createConnectionDB(this);
        especieRepository=new EspecieRepository(connection);
        localizacaoEspecieRepository=new LocalizacaoEspecieRepository(connection);

        MetodoPreservacaoRepository metodoPreservacaoRepository=new MetodoPreservacaoRepository(connection);
        PreservacaoEspecieRepository preservacaoEspecieRepository=new PreservacaoEspecieRepository(connection);
        QuemEncontrouRepository quemEncontrouRepository=new QuemEncontrouRepository(connection);
        QuemIdentificouRepository quemIdentificouRepository=new QuemIdentificouRepository(connection);
        PessoaRepository pessoaRepository=new PessoaRepository(connection);
        UtilizadorRepository utilizadorRepository=new UtilizadorRepository(connection);
        //createConnectionDB();

        List<Especie> list=especieRepository.getAll();
        List<LocalizacaoEspecie> localizacaoEspecieList=localizacaoEspecieRepository.getAll();

        for(Especie especie: list){
            textView.append("\n"+especie+"\n");
        }

            /*for (LocalizacaoEspecie localizacaoEspecie: localizacaoEspecieList)
                if (localizacaoEspecie.getEspecie().getIdEspecie()==especie.getIdEspecie()) {

                    List<QuemEncontrou> quemEncontrouList=quemEncontrouRepository.getAll();
                    QuemEncontrou quemEncontrou=new QuemEncontrou();

                    for (QuemEncontrou quemEncontrou1: quemEncontrouList){
                     /*   if(quemEncontrou1.getEspecie().getIdEspecie()==especie.getIdEspecie()){
                            quemEncontrou=quemEncontrou1;
                            break;
                        }*/
                      //  textView.append("Especie Info: \n" + especie + "\n\n" + "Especie Localizacao: \n" +localizacaoEspecie+"\n");

                   // textView.append("Especie Info: \n" + especie + "\n\n" + "Especie Localizacao: \n" +localizacaoEspecie+"\n");
                    //textView.append("\nQuem encontrou.: \n"+quemEncontrou);
                   // break;
          //      }
        //}




/*
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        lstDados.setLayoutManager(linearLayoutManager);

        especieRepository=new EspecieRepository(connection);
        List<Especie> dados=especieRepository.getAll();
        especieAdapter=new EspecieAdapter(dados);

        lstDados.setAdapter(especieAdapter);
        */

/*
        tipoUtilizadorRepository=new TipoUtilizadorRepository(connection);
        List<TipoUtilizador> dados=tipoUtilizadorRepository.getAll();
        tipoUtilizadorAdapter=new TipoUtilizadorAdapter(dados);

        lstDados.setAdapter(tipoUtilizadorAdapter);
        */
    }

    private void createConnectionDB(){
        try{
            dataBaseOpenHelper=new DataBaseOpenHelper(this);
            connection=dataBaseOpenHelper.getWritableDatabase();


            especieRepository=new EspecieRepository(connection);
            provinciaRepository=new ProvinciaRepository(connection);
//            Snackbar.make(lstDados, R.string.msg_sucess_conectionDB, Snackbar.LENGTH_SHORT).setAction("ok",null).show();

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

        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {   //quando selecionamos um dos itens do menu criado

        int id=item.getItemId();

        switch (id){
            case R.id.action_lg:{
                intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                //  Toast.makeText(this,"Ok selecoonado",Toast.LENGTH_SHORT).show();
            }break;
            case R.id.app_bar_search:{
                Toast.makeText(this,"Cancelar selecoonado",Toast.LENGTH_SHORT).show();
            }break;

            default:{
                System.out.println("Invalid Option");
            }break;

        }

        return super.onOptionsItemSelected(item);
    }

}
