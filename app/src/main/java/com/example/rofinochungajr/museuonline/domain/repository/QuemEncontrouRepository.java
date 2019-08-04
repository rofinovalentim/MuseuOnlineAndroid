package com.example.rofinochungajr.museuonline.domain.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rofinochungajr.museuonline.domain.model.QuemEncontrou;


import java.util.ArrayList;
import java.util.List;

public class QuemEncontrouRepository {
    private SQLiteDatabase connection;
    private static final String table="quemencontrou";
    private PessoaRepository pessoaRepository;
    private EspecieRepository especieRepository;

    public QuemEncontrouRepository(SQLiteDatabase connection) {
        this.connection = connection;
        this.especieRepository=new EspecieRepository(connection);
        this.pessoaRepository=new PessoaRepository(connection);
    }

    public long insert(QuemEncontrou quemEncontrou){
        ContentValues contentValues=new ContentValues();

        contentValues.put("idPessoa",quemEncontrou.getPessoa().getIdPessoa());
        contentValues.put("idEspecie",quemEncontrou.getEspecie().getIdEspecie());

        return connection.insertOrThrow(table,null,contentValues);
    }

    public void delete(QuemEncontrou quemEncontrou){



        String[] parameters = new String[2];
        parameters[0] = String.valueOf(quemEncontrou.getPessoa().getIdPessoa());
        parameters[1]=String.valueOf(quemEncontrou.getEspecie().getIdEspecie());

        connection.delete(table, "idPessoa = ? AND idEspecie = ?", parameters);
    }

    public void update(QuemEncontrou quemEncontrou){
        ContentValues contentValues=new ContentValues();
        contentValues.put("idPessoa",quemEncontrou.getPessoa().getIdPessoa());
        contentValues.put("idEspecie",quemEncontrou.getEspecie().getIdEspecie());

        String[] parameters = new String[2];
        parameters[0] = String.valueOf(quemEncontrou.getPessoa().getIdPessoa());
        parameters[1]=String.valueOf(quemEncontrou.getEspecie().getIdEspecie());

        connection.update(table, contentValues, "idPessoa = ? AND idEspecie", parameters);
    }

    public List<QuemEncontrou> getAll(){
        List<QuemEncontrou> quemEncontrouList=new ArrayList<>();


        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idPessoa,  idEspecie ");
        sql.append(" FROM "+table);

        Cursor result = connection.rawQuery(sql.toString(), null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                QuemEncontrou quemEncontrou = new QuemEncontrou();

                Integer idEspecie= result.getInt(result.getColumnIndexOrThrow("idEspecie"));
                Integer idPessoa=result.getInt(result.getColumnIndexOrThrow("idPessoa"));

                quemEncontrouList.add(quemEncontrou);

            } while (result.moveToNext());
        }
        return quemEncontrouList;
    }

}
