package com.example.rofinochungajr.museuonline.domain.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rofinochungajr.museuonline.domain.model.MetodoDePreservacao;

import java.util.ArrayList;
import java.util.List;

public class MetodoPreservacaoRepository {

    private SQLiteDatabase connection;
    private static final String table="metododepreservacao";

    public MetodoPreservacaoRepository(SQLiteDatabase connection) {
        this.connection = connection;
    }

    public long insert(MetodoDePreservacao metodoDePreservacao) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("Metodo", metodoDePreservacao.getMetodo());
        long idMetodoConservacao=connection.insertOrThrow(table, null, contentValues);
        return idMetodoConservacao;
    }

    public void delete(int idMetodoConservacao) {
        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idMetodoConservacao);

        connection.delete(table, "idMetodoDePreservacao = ?", parameters);
    }

    public void update(MetodoDePreservacao metodoDePreservacao) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("Metodo", metodoDePreservacao.getMetodo());

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(metodoDePreservacao.getIdMetodo());

        connection.update(table, contentValues, "idMetodoDePreservacao = ?", parameters);
    }



    public List<MetodoDePreservacao> getAll() {

        List<MetodoDePreservacao> metodoDePreservacaoList = new ArrayList<MetodoDePreservacao>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idMetodoDePreservacao, Metodo ");
        sql.append(" FROM "+table);

        Cursor result = connection.rawQuery(sql.toString(), null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                MetodoDePreservacao metodoDePreservacao = new MetodoDePreservacao();

                metodoDePreservacao.setIdMetodo(result.getInt(result.getColumnIndexOrThrow("idMetodoDePreservacao")));
                metodoDePreservacao.setMetodo(result.getString(result.getColumnIndexOrThrow("Metodo")));
                metodoDePreservacaoList.add(metodoDePreservacao);

            } while (result.moveToNext());

        }
        return metodoDePreservacaoList;
    }

    public MetodoDePreservacao get(int idMetodoPreservacao) {

        MetodoDePreservacao metodoDePreservacao = new MetodoDePreservacao();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idMetodoDePreservacao,  Metodo ");
        sql.append(" FROM "+table);
        sql.append(" where idMetodoDePreservacao = ?");

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idMetodoPreservacao);

        Cursor result = connection.rawQuery(sql.toString(), parameters);

        if (result.getCount() > 0) {
            result.moveToFirst();

            metodoDePreservacao.setIdMetodo(result.getInt(result.getColumnIndexOrThrow("idMetodoDePreservacao")));
            metodoDePreservacao.setMetodo(result.getString(result.getColumnIndexOrThrow("Metodo")));

            return metodoDePreservacao;
        }
        return null;
    }
}
