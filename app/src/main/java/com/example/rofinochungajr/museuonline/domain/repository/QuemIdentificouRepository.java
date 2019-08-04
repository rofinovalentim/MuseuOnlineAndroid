package com.example.rofinochungajr.museuonline.domain.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rofinochungajr.museuonline.domain.model.QuemIdentificou;

import java.util.ArrayList;
import java.util.List;

public class QuemIdentificouRepository {

    private SQLiteDatabase connection;
    private static final String table="quemidentificou";

    public QuemIdentificouRepository(SQLiteDatabase connection) {
        this.connection = connection;
    }

    public long insert(QuemIdentificou quemIdentificou){
        ContentValues contentValues=new ContentValues();

        contentValues.put("idPessoa",quemIdentificou.getPessoa().getIdPessoa());
        contentValues.put("idEspecie",quemIdentificou.getEspecie().getIdEspecie());

        return connection.insertOrThrow(table,null,contentValues);
    }

    public void delete(QuemIdentificou quemIdentificou){



        String[] parameters = new String[2];
        parameters[0] = String.valueOf(quemIdentificou.getPessoa().getIdPessoa());
        parameters[1]=String.valueOf(quemIdentificou.getEspecie().getIdEspecie());

        connection.delete(table, "idPessoa = ? AND idEspecie = ?", parameters);
    }

    public void update(QuemIdentificou quemIdentificou){
        ContentValues contentValues=new ContentValues();
        contentValues.put("idPessoa",quemIdentificou.getPessoa().getIdPessoa());
        contentValues.put("idEspecie",quemIdentificou.getEspecie().getIdEspecie());

        String[] parameters = new String[2];
        parameters[0] = String.valueOf(quemIdentificou.getPessoa().getIdPessoa());
        parameters[1]=String.valueOf(quemIdentificou.getEspecie().getIdEspecie());

        connection.update(table, contentValues, "idPessoa = ? AND idEspecie", parameters);
    }

    public List<QuemIdentificou> getAll(){
        List<QuemIdentificou> quemIdentificouList=new ArrayList<>();


        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idPessoa,  idEspecie ");
        sql.append(" FROM "+table);

        Cursor result = connection.rawQuery(sql.toString(), null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                QuemIdentificou quemIdentificou = new QuemIdentificou();

                Integer idEspecie= result.getInt(result.getColumnIndexOrThrow("idEspecie"));
                Integer idPessoa=result.getInt(result.getColumnIndexOrThrow("idPessoa"));

                quemIdentificouList.add(quemIdentificou);

            } while (result.moveToNext());
        }
        return quemIdentificouList;
    }
    //public QuemIdentificou get()
}
