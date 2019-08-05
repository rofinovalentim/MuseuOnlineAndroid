package com.example.rofinochungajr.museuonline.domain.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rofinochungajr.museuonline.domain.model.Reino;

import java.util.ArrayList;
import java.util.List;

public class ReinoRepository {
    private SQLiteDatabase connection;
    private static final String table="reino";
    public ReinoRepository(SQLiteDatabase connection){
        this.connection=connection;
    }

    public long insert(Reino reino){
        ContentValues contentValues=new ContentValues();
        contentValues.put("Reino",reino.getReino());

        return connection.insertOrThrow(table,null,contentValues);
    }

    public void update(Reino reino){
        ContentValues contentValues=new ContentValues();
        contentValues.put("Reino",reino.getReino());

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(reino.getIdReino());

        connection.update(table, contentValues, "idReino = ?", parameters);

    }
    public void delete(Integer idReino){
        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idReino);

        connection.delete(table, "idReino = ?", parameters);
    }

    public List<Reino> getAll(){
        List<Reino> reinoList=new ArrayList<>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idReino,  Reino ");
        sql.append(" FROM " + table);

        Cursor result = connection.rawQuery(sql.toString(), null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                Reino reino = new Reino();

                reino.setIdReino(result.getInt(result.getColumnIndexOrThrow("idReino")));
                reino.setReino(result.getString(result.getColumnIndexOrThrow("Reino")));

                reinoList.add(reino);

            } while (result.moveToNext());

        }
        return reinoList;
    }

    public Reino get(Integer idReino){
        Reino reino = new Reino();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idReino,  Reino ");
        sql.append(" FROM " + table);
        sql.append(" where idReino = ?");

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idReino);

        Cursor result = connection.rawQuery(sql.toString(), parameters);

        if (result.getCount() > 0) {
            result.moveToFirst();

            reino.setIdReino(result.getInt(result.getColumnIndexOrThrow("idReino")));
            reino.setReino(result.getString(result.getColumnIndexOrThrow("Reino")));

            return reino;
        }
        return null;
    }

}
