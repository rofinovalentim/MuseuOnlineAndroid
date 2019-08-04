package com.example.rofinochungajr.museuonline;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.rofinochungajr.museuonline.database.DataBaseOpenHelper;
import com.example.rofinochungajr.museuonline.domain.model.Especie;
import com.example.rofinochungajr.museuonline.domain.model.Genero;
import com.example.rofinochungajr.museuonline.domain.model.TipoUtilizador;
import com.example.rofinochungajr.museuonline.domain.repository.EspecieRepository;
import com.example.rofinochungajr.museuonline.domain.repository.GeneroRepository;
import com.example.rofinochungajr.museuonline.domain.repository.TipoUtilizadorRepository;
import com.example.rofinochungajr.museuonline.staticsmethods.StaticsMethods;

import java.util.List;

public class FormEspecieActivity extends AppCompatActivity {
    private EditText editTextNomeEspecie;
    private EditText editTextNomeComum;
    private Spinner spinnerGenero;
    private Genero genero;
    private EditText editTextCoordenadas;
    private EditText editTextHabitat;
    private EditText editTextNotas;
    private EditText editTextCodigo;
    private EditText editTextValidacao;
    private EditText editTextDetalhes;

    private TipoUtilizadorRepository utilizadorRepository;
    private TipoUtilizador utilizador;
    private Especie especie;
    private EspecieRepository especieRepository;
    private SQLiteDatabase connection;
    private DataBaseOpenHelper dataBaseOpenHelper;
    private ConstraintLayout constraintLayout;
    private GeneroRepository generoRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_especie);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // FloatingActionButton fab = findViewById(R.id.fab);

        editTextNomeEspecie = (EditText) findViewById(R.id.editTextNomeEspecie);
        editTextNomeComum = (EditText) findViewById(R.id.editTextNomeComum);
        spinnerGenero = (Spinner) findViewById(R.id.spinnerGenero);
        editTextCoordenadas = (EditText) findViewById(R.id.editTextCoordenadas);
        editTextHabitat = (EditText) findViewById(R.id.editTextHabitat);
        editTextNotas = (EditText) findViewById(R.id.editTextNotas);
        editTextCodigo = (EditText) findViewById(R.id.editTextCodigo);
        editTextValidacao = (EditText) findViewById(R.id.editTextValidacao);
        editTextDetalhes = (EditText) findViewById(R.id.editTextDetalhes);

        connection = StaticsMethods.createConnectionDB(this);

        generoRepository = new GeneroRepository(connection);


//        createConnectionDB();

        List<Genero> list = generoRepository.getAll();//new ArrayList<>();


        ArrayAdapter<Genero> adapter = new ArrayAdapter<Genero>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGenero.setAdapter(adapter);

       /* spinnerGenero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                genero = (Genero) parent.getItemAtPosition(position);
                Toast.makeText(FormEspecieActivity.this, "Selected: " + genero, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/

        //constraintLayout=(ConstraintLayout)findViewById(R.id.constraintFormEspecie);




      /*  fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action ===" + editTextNomeEspecie.getText(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    }


    public boolean isEmpty(String value) {
        boolean result = (TextUtils.isEmpty(value) || value.trim().isEmpty());

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

        int id = item.getItemId();

        switch (id) {
            case android.R.id.home: {
                finish();
                break;
            }
            case R.id.action_next: {
                confirm();

                // startActivity(intent);
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
                confirm();
            }
            break;

            default: {
                System.out.println("Invalid Option");
            }
            break;

        }

        return super.onOptionsItemSelected(item);
    }


    private boolean validation() {

        boolean result = false;
        String nomeEspecie = editTextNomeEspecie.getText().toString();
        String nomeComum = editTextNomeComum.getText().toString();

        String habitat = editTextHabitat.getText().toString();
        String coordenadas = editTextCoordenadas.getText().toString();
        String notas = editTextNotas.getText().toString();
        String detalhes = editTextDetalhes.getText().toString();
        String codigo = editTextCodigo.getText().toString();
        String validacao = editTextValidacao.getText().toString();


        genero = (Genero) spinnerGenero.getSelectedItem();

        especie.setNomeEspecie(nomeEspecie);
        especie.setNomeComum(nomeComum);
        especie.setHabitat(habitat);
        especie.setCoordenadas(coordenadas);
        especie.setNotas(notas);
        especie.setCodigo(codigo);
        especie.setValidacao(validacao);
        especie.setDetalhes(detalhes);
        especie.setGenero(genero);


        //utilizador.setTipoUtilizador("teste");


        if (result = isEmpty(nomeEspecie)) {
            editTextNomeEspecie.requestFocus();
        } else {
            if (result = isEmpty(nomeComum)) {
                editTextNomeComum.requestFocus();
            } else {
                if (result = isEmpty(habitat)) {
                    editTextHabitat.requestFocus();
                } else {
                    if (result = isEmpty(coordenadas)) {
                        editTextCoordenadas.requestFocus();
                    } else {
                        if (result = isEmpty(notas)) {
                            editTextNotas.requestFocus();
                        } else {
                            if (result = isEmpty(codigo)) {
                                editTextCodigo.requestFocus();
                            } else {
                                if (result = isEmpty(validacao)) {
                                    editTextValidacao.requestFocus();
                                } else {
                                    if (result = isEmpty(detalhes)) {
                                        editTextDetalhes.requestFocus();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (result) {

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle(R.string.title_aviso);
            dlg.setMessage("Ha campos vasios ");
            dlg.setNeutralButton(R.string.msg_ok, null);
            dlg.show();

        }
        return result;
    }


    private long confirm() {


        utilizador = new TipoUtilizador();
        especie = new Especie();
        especieRepository = new EspecieRepository(StaticsMethods.createConnectionDB(this));
        if (validation() == false) {

            try {
                Integer idEspecie =(int) especieRepository.insert(especie);

                Intent intent = new Intent(FormEspecieActivity.this, IdentificaoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("ESPECIE", especieRepository.get(idEspecie));
                intent.putExtras(bundle);

                startActivityForResult(intent, 0);
                return idEspecie;
            } catch (SQLException ex) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(this);

                dlg.setTitle(R.string.title_aviso);
                dlg.setMessage(ex.getMessage());
                dlg.setNeutralButton(R.string.msg_ok, null);

            }
        }
        return -1;
    }

}
