package com.example.rofinochungajr.museuonline.domain.repository;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rofinochungajr.museuonline.domain.model.Provincia;
import com.example.rofinochungajr.museuonline.domain.model.Regiao;

import java.util.ArrayList;
import java.util.List;

public class RegiaoRepository {
    private SQLiteDatabase connection;


    public RegiaoRepository(SQLiteDatabase connection) {
        this.connection = connection;
    }

    public List<Regiao> getAll() {

        List<Regiao> regiaoList = new ArrayList<Regiao>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idRegiao,  Regiao ");
        sql.append(" FROM regiao");

        Cursor result = connection.rawQuery(sql.toString(), null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                Regiao regiao = new Regiao();

                regiao.setIdRegiao(result.getInt(result.getColumnIndexOrThrow("idRegiao")));
                regiao.setRegiao(result.getString(result.getColumnIndexOrThrow("Regiao")));


                regiaoList.add(regiao);

            } while (result.moveToNext());

        }
        return regiaoList;
    }

    public Regiao get(int idRegiao) {

        Regiao regiao = new Regiao();

        StringBuilder sql = new StringBuilder();


        sql.append("SELECT idRegiao,  Regiao ");
        sql.append(" FROM regiao");
        sql.append(" where idRegiao = ?");

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idRegiao);

        Cursor result = connection.rawQuery(sql.toString(), parameters);

        if (result.getCount() > 0) {
            result.moveToFirst();

            regiao.setIdRegiao(result.getInt(result.getColumnIndexOrThrow("idRegiao")));
            regiao.setRegiao(result.getString(result.getColumnIndexOrThrow("Regiao")));

            return regiao;
        }
        return null;
    }
}
