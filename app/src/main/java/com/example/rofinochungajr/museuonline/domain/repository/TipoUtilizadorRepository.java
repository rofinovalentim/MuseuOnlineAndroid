package com.example.rofinochungajr.museuonline.domain.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rofinochungajr.museuonline.domain.model.TipoUtilizador;

import java.util.ArrayList;
import java.util.List;

public class TipoUtilizadorRepository {


    private SQLiteDatabase connection;


    public TipoUtilizadorRepository(SQLiteDatabase connection) {
        this.connection = connection;
    }


    public void insert(TipoUtilizador tipoUtilizador) {
        ContentValues contentValues = new ContentValues();

        //contentValues.put("idtipoutilizador", tipoUtilizador.getIdTipoUtilizador());
        contentValues.put("tipoutilizador", tipoUtilizador.getTipoUtilizador());
        //contentValues.put("idtipoutilizador", user.getTipoUtilizador().getIdTipoUtilizador());

        connection.insertOrThrow("tipoutilizador", null, contentValues);

    }

    public void delete(int idTipoUtilizador) {
        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idTipoUtilizador);

        connection.delete("tipoutilizador", "idtipoutilizador = ?", parameters);
    }

    public void update(TipoUtilizador tipoUtilizador) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("idtipoutilizador", tipoUtilizador.getIdTipoUtilizador());
        contentValues.put("tipoutilizador", tipoUtilizador.getTipoUtilizador());
        //contentValues.put("idtipoutilizador", user.getTipoUtilizador().getIdTipoUtilizador());

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(tipoUtilizador.getIdTipoUtilizador());


        connection.update("tipoutilizador", contentValues, "idtipoutilizador = ?", parameters);

    }

    public List<TipoUtilizador> getAll() {

        List<TipoUtilizador> tipoUtilizadorList = new ArrayList<TipoUtilizador>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idtipoutilizador , tipoutilizador ");
        sql.append(" FROM tipoutilizador");

        Cursor result = connection.rawQuery(sql.toString(), null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                TipoUtilizador tipoUtilizador = new TipoUtilizador();

                tipoUtilizador.setIdTipoUtilizador(result.getInt(result.getColumnIndexOrThrow("idtipoutilizador")));
                tipoUtilizador.setTipoUtilizador(result.getString(result.getColumnIndexOrThrow("tipoutilizador")));
               /* utilizador.setPassword(result.getString(result.getColumnIndexOrThrow("Senha")));
                utilizador.getTipoUtilizador().setIdTipoUtilizador(result.getInt(result.getColumnIndexOrThrow("idtipoutilizador")));
                */

                tipoUtilizadorList.add(tipoUtilizador);

            } while (result.moveToNext());

        }
        return tipoUtilizadorList;
    }

    public TipoUtilizador getTipoUtilizador(int idTipoUtilizador) {

        TipoUtilizador tipoUtilizador = new TipoUtilizador();

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT idtipoutilizador, tipoutilizador");
        sql.append(" FROM tipoutilizador");
        sql.append(" where idtipoutilizador = ?");

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idTipoUtilizador);

        Cursor result = connection.rawQuery(sql.toString(), parameters);

        if (result.getCount() > 0) {
            result.moveToFirst();

            tipoUtilizador.setIdTipoUtilizador(result.getInt(result.getColumnIndexOrThrow("idtipoutilizador")));
            tipoUtilizador.setTipoUtilizador(result.getString(result.getColumnIndexOrThrow("tipoutilizador")));

            return tipoUtilizador;
        }
        return null;
    }


}
