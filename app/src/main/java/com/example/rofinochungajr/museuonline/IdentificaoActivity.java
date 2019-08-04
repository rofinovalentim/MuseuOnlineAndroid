package com.example.rofinochungajr.museuonline;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.rofinochungajr.museuonline.database.DataBaseOpenHelper;
import com.example.rofinochungajr.museuonline.domain.model.Ameaca;
import com.example.rofinochungajr.museuonline.domain.model.Distrito;
import com.example.rofinochungajr.museuonline.domain.model.Especie;
import com.example.rofinochungajr.museuonline.domain.model.EspecieAmeaca;
import com.example.rofinochungajr.museuonline.domain.model.LocalizacaoEspecie;
import com.example.rofinochungajr.museuonline.domain.model.MetodoDePreservacao;
import com.example.rofinochungajr.museuonline.domain.model.Pessoa;
import com.example.rofinochungajr.museuonline.domain.model.PreservacaoEspecie;
import com.example.rofinochungajr.museuonline.domain.model.Provincia;
import com.example.rofinochungajr.museuonline.domain.model.QuemEncontrou;
import com.example.rofinochungajr.museuonline.domain.model.QuemIdentificou;
import com.example.rofinochungajr.museuonline.domain.model.Regiao;
import com.example.rofinochungajr.museuonline.domain.repository.AmeacasRepository;
import com.example.rofinochungajr.museuonline.domain.repository.DistritoRepository;
import com.example.rofinochungajr.museuonline.domain.repository.EspecieAmeacaRepository;
import com.example.rofinochungajr.museuonline.domain.repository.EspecieRepository;
import com.example.rofinochungajr.museuonline.domain.repository.LocalizacaoEspecieRepository;
import com.example.rofinochungajr.museuonline.domain.repository.MetodoPreservacaoRepository;
import com.example.rofinochungajr.museuonline.domain.repository.PessoaRepository;
import com.example.rofinochungajr.museuonline.domain.repository.PreservacaoEspecieRepository;
import com.example.rofinochungajr.museuonline.domain.repository.ProvinciaRepository;
import com.example.rofinochungajr.museuonline.domain.repository.QuemEncontrouRepository;
import com.example.rofinochungajr.museuonline.domain.repository.QuemIdentificouRepository;
import com.example.rofinochungajr.museuonline.domain.repository.RegiaoRepository;
import com.example.rofinochungajr.museuonline.staticsmethods.StaticsMethods;

import java.util.List;

public class IdentificaoActivity extends AppCompatActivity {

    private Spinner spinnerProvincia;
    private Spinner spinnerDistrito;
    private Spinner spinnerRegiao;
    private Spinner spinnerAmeaca;
    private EditText editTextQuemEncontrou;
    private EditText editTextQuemIdentificou;
    private EditText editTextMetodoPreservacao;
    private DataBaseOpenHelper dataBaseOpenHelper;
    private RegiaoRepository regiaoRepository;
    private ProvinciaRepository provinciaRepository;
    private DistritoRepository distritoRepository;
    private EspecieRepository especieRepository;
    private EspecieAmeacaRepository especieAmeacaRepository;
    private AmeacasRepository ameacasRepository;
    private PreservacaoEspecieRepository preservacaoEspecieRepository;
    private MetodoPreservacaoRepository metodoPreservacaoRepository;
    private LocalizacaoEspecieRepository localizacaoEspecieRepository;
    private PessoaRepository pessoaRepository;
    private QuemEncontrouRepository quemEncontrouRepository;
    private QuemIdentificouRepository quemIdentificouRepository;

    private SQLiteDatabase connection;
    private Provincia provincia;
    private Distrito distrito;
    private Pessoa pessoa;
    private Ameaca ameaca;
    private QuemEncontrou quemEncontrou;
    private QuemIdentificou quemIdentificou;
    private MetodoDePreservacao metodoDePreservacao;
    private LocalizacaoEspecie localizacaoEspecie;
    private Especie especie;
    private Regiao regiao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identificao);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spinnerProvincia=(Spinner)findViewById(R.id.spinnerProvincia);
        spinnerDistrito=(Spinner)findViewById(R.id.spinnerDistrito);
        spinnerRegiao=(Spinner)findViewById(R.id.spinnerRegiao);
        spinnerAmeaca=(Spinner)findViewById(R.id.spinerAmeaca) ;
        editTextMetodoPreservacao=(EditText)findViewById(R.id.editTextMetodoPreservacao);
        editTextQuemEncontrou=(EditText) findViewById(R.id.editTextIdentificador);
        editTextQuemIdentificou=(EditText)findViewById(R.id.editTextIdentificador2);

        connection=StaticsMethods.createConnectionDB(this);

        provinciaRepository=new ProvinciaRepository(connection);
        distritoRepository=new DistritoRepository(connection);
        regiaoRepository=new RegiaoRepository(connection);
        especieRepository=new EspecieRepository(connection);
        localizacaoEspecieRepository=new LocalizacaoEspecieRepository(connection);
        especieAmeacaRepository= new EspecieAmeacaRepository(connection);
        ameacasRepository=new AmeacasRepository(connection);
        pessoaRepository=new PessoaRepository(connection);
        metodoPreservacaoRepository=new MetodoPreservacaoRepository(connection);
        preservacaoEspecieRepository=new PreservacaoEspecieRepository(connection);
        quemEncontrouRepository=new QuemEncontrouRepository(connection);
        quemIdentificouRepository=new QuemIdentificouRepository(connection);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();

        if(bundle!=null){
            especie=(Especie) bundle.getSerializable("ESPECIE");
            Toast.makeText(this,"O objecto passado"+especie,Toast.LENGTH_LONG).show();
        }



      /*  Intent intent = getIntent();
        Bundle bundle = intent.getExtras();*/
//Tipo de objeto = (Tipo) bundle.getSerializable("KEY");
      //   myData = (DataClass) bundle.getSerializable("MY_DATA");
     /*   Integer idEspecie= bundle.getInt("ESPECIE");

        especie=especieRepository.getOne(idEspecie);*/

//        Toast.makeText(this,especie.getNomeComum(),Toast.LENGTH_LONG).show();


        List<Regiao> regiaoList=regiaoRepository.getAll();
        ArrayAdapter<Regiao> regiaoAdapter =new ArrayAdapter<Regiao>(this,android.R.layout.simple_spinner_item,regiaoList);
        regiaoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRegiao.setAdapter(regiaoAdapter);



        /*spinnerRegiao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         /*   @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


              /*  regiao= (Regiao) parent.getItemAtPosition(position);
                Toast.makeText(IdentificaoActivity.this, "Selected: "+regiao,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/



        List<Provincia> list=provinciaRepository.getAll();
        ArrayAdapter<Provincia> adapter=new ArrayAdapter<Provincia>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProvincia.setAdapter(adapter);

      /*  spinnerProvincia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

             //   distritoList=distritoRepository.getDistritoByProvincia(provincia.getIdProvicia());

                provincia= (Provincia) parent.getSelectedItem();//.getItemAtPosition(position);
           //    Toast.makeText(IdentificaoActivity.this, "Selected: "+provincia,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        */


        //Toast.makeText(IdentificaoActivity.this, "Selected: "+provincia,Toast.LENGTH_SHORT).show();


        provincia=(Provincia) spinnerProvincia.getSelectedItem();


        List<Distrito> distritoList=distritoRepository.getDistritoByProvincia(provincia.getIdProvicia());        ArrayAdapter<Distrito> distritoArrayAdapter=new ArrayAdapter<Distrito>(this,android.R.layout.simple_spinner_item,distritoList);
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

        List<Ameaca> ameacasList=ameacasRepository.getAll();
        ArrayAdapter<Ameaca> ameacaArrayAdapter=new ArrayAdapter<Ameaca>(this,android.R.layout.simple_spinner_item,ameacasList);
        ameacaArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAmeaca.setAdapter(ameacaArrayAdapter);

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
            case android.R.id.home:{
                finish();
                break;
            }
            case R.id.action_next:{
                Intent intent=new Intent(IdentificaoActivity.this,MultimidiaActivity.class);
                startActivity(intent);
            }break;
            case R.id.action_cancelar:{
                Toast.makeText(this,"Cancelar selecoonado",Toast.LENGTH_SHORT).show();
            }break;

            case R.id.action_save:{
                confirm();
            }break;
        }

        return super.onOptionsItemSelected(item);
    }


    private boolean validation(){
        boolean result=false;
        String mtdPreservacao=editTextMetodoPreservacao.getText().toString();

        // String ameacas=editTextAmeacas.getText().toString();
        String qEncontrou=editTextQuemEncontrou.getText().toString();
        String qIdentificou=editTextQuemIdentificou.getText().toString();
        Regiao regiao=(Regiao) spinnerRegiao.getSelectedItem();
        Provincia provincia=(Provincia) spinnerProvincia.getSelectedItem();
        Distrito distrito=(Distrito) spinnerDistrito.getSelectedItem();

        localizacaoEspecie.setRegiao(regiao);
        localizacaoEspecie.setProvincia(provincia);
        localizacaoEspecie.setDistrito(distrito);
        localizacaoEspecie.setEspecie(especie);


        /*if (){

        }*/


        return result;
    }

    private void confirm(){

        localizacaoEspecie=new LocalizacaoEspecie();

        validation();
        try{
            localizacaoEspecieRepository.insert(localizacaoEspecie);
            String metodo=editTextMetodoPreservacao.getText().toString();
            Integer idMetodo=(int) metodoPreservacaoRepository.insert(new MetodoDePreservacao(null,metodo));
            preservacaoEspecieRepository.insert(new PreservacaoEspecie(null,metodoPreservacaoRepository.get(idMetodo),especie));
            ameaca=(Ameaca) spinnerAmeaca.getSelectedItem();
            especieAmeacaRepository.insert(new EspecieAmeaca(especie,ameaca));
            String quemIdentificou=editTextQuemIdentificou.getText().toString();
            Integer idPessoa=(int)pessoaRepository.insert(new Pessoa(null,quemIdentificou));
            quemIdentificouRepository.insert(new QuemIdentificou(pessoaRepository.get(idPessoa),especie));
            String quemEncotrou=editTextQuemEncontrou.getText().toString();
            idPessoa=(int)pessoaRepository.insert(new Pessoa(null,quemEncotrou));
            quemEncontrouRepository.insert(new QuemEncontrou(pessoaRepository.get(idPessoa),especie));

        }catch (SQLException e){

        }

    }
}

