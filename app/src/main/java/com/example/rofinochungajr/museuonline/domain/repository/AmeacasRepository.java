package com.example.rofinochungajr.museuonline.domain.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rofinochungajr.museuonline.domain.model.Ameaca;
import com.example.rofinochungajr.museuonline.domain.model.Distrito;
import com.example.rofinochungajr.museuonline.domain.model.Regiao;

import java.util.ArrayList;
import java.util.List;

public class AmeacasRepository {

    private SQLiteDatabase connection;
    private static final String table="ameacas";


    public AmeacasRepository(SQLiteDatabase connection) {
        this.connection = connection;
    }

    public long insert(Ameaca ameaca) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("ameaca",ameaca.getAmeaca());

        long idDistrito=connection.insertOrThrow(table, null, contentValues);
        return idDistrito;
    }

    public void delete(int idAmeaca) {
        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idAmeaca);

        connection.delete(table, "idAmeaca = ?", parameters);
    }

    public void update(Ameaca ameaca) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("ameaca",ameaca.getAmeaca());

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(ameaca.getIdAmeaca());


        connection.update(table, contentValues, "idAmeaca = ?", parameters);

    }

    public List<Ameaca> getAll() {

        List<Ameaca> ameacaList = new ArrayList<Ameaca>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idAmeaca,  ameaca ");
        sql.append(" FROM "+table);

        Cursor result = connection.rawQuery(sql.toString(), null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                Ameaca ameaca= new Ameaca();

                ameaca.setIdAmeaca(result.getInt(result.getColumnIndexOrThrow("idAmeaca")));
                ameaca.setAmeaca(result.getString(result.getColumnIndexOrThrow("ameaca")));


                ameacaList.add(ameaca);

            } while (result.moveToNext());

        }
        return ameacaList;
    }

    public Ameaca get(int idAmeaca) {

        Ameaca ameaca = new Ameaca();

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT idAmeaca,  ameaca ");
        sql.append(" FROM "+table);
        sql.append(" where idAmeaca = ?");

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idAmeaca);

        Cursor result = connection.rawQuery(sql.toString(), parameters);

        if (result.getCount() > 0) {
            result.moveToFirst();

            ameaca.setIdAmeaca(result.getInt(result.getColumnIndexOrThrow("idAmeaca")));
            ameaca.setAmeaca(result.getString(result.getColumnIndexOrThrow("ameaca")));

            return ameaca;
        }
        return null;
    }
}
