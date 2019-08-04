package com.example.rofinochungajr.museuonline.domain.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rofinochungajr.museuonline.domain.model.Distrito;
import com.example.rofinochungajr.museuonline.domain.model.Provincia;
import com.example.rofinochungajr.museuonline.domain.model.TipoUtilizador;


import java.util.ArrayList;
import java.util.List;

public class DistritoRepository {

    private SQLiteDatabase connection;
    private ProvinciaRepository provinciaRepository;
    private static final String table = "distrito";

    public DistritoRepository(SQLiteDatabase connection) {
        this.connection = connection;
        this.provinciaRepository = new ProvinciaRepository(connection);
    }

    public long insert(Distrito distrito) {
        ContentValues contentValues = new ContentValues();

        //  contentValues.put("idDistrito", distrito.getIdTipoUtilizador());
        contentValues.put("Distrito", distrito.getDistrito());
        contentValues.put("idProvincia", distrito.getProvincia().getIdProvicia());


        long idDistrito = connection.insertOrThrow(table, null, contentValues);
        return idDistrito;
    }

    public void delete(int idDistrito) {
        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idDistrito);

        connection.delete(table, "idDistrito = ?", parameters);
    }

    public void update(Distrito distrito) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("Distrito", distrito.getDistrito());
        contentValues.put("idProvincia", distrito.getProvincia().getIdProvicia());

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(distrito.getIdDistrito());


        connection.update(table, contentValues, "idDistrito = ?", parameters);

    }


    public List<Distrito> getAll() {

        List<Distrito> distritoList = new ArrayList<Distrito>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idDistrito,  Distrito, idProvincia ");
        sql.append(" FROM " + table);

        Cursor result = connection.rawQuery(sql.toString(), null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                Distrito distrito = new Distrito();

                distrito.setIdDistrito(result.getInt(result.getColumnIndexOrThrow("idDistrito")));
                distrito.setDistrito(result.getString(result.getColumnIndexOrThrow("Distrito")));
                int idProvincia = result.getInt(result.getColumnIndexOrThrow("idProvincia"));
                distrito.setProvincia(provinciaRepository.get(idProvincia));

                distritoList.add(distrito);

            } while (result.moveToNext());

        }
        return distritoList;
    }

    public List<Distrito> getDistritoByProvincia(int idProvincia) {

        List<Distrito> distritoList = new ArrayList<Distrito>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idDistrito,  Distrito, idProvincia ");
        sql.append(" FROM " + table);

        sql.append(" where idProvincia = ?");

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idProvincia);

        Cursor result = connection.rawQuery(sql.toString(), parameters);

        //Cursor result = connection.rawQuery(sql.toString(), null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                Distrito distrito = new Distrito();

                distrito.setIdDistrito(result.getInt(result.getColumnIndexOrThrow("idDistrito")));
                distrito.setDistrito(result.getString(result.getColumnIndexOrThrow("Distrito")));
                //int idProvincia=result.getInt(result.getColumnIndexOrThrow("idProvincia"));
                distrito.setProvincia(provinciaRepository.get(idProvincia));

                distritoList.add(distrito);

            } while (result.moveToNext());

        }
        return distritoList;
    }

    public Distrito get(int idDistrito) {

        Distrito distrito = new Distrito();

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT idDistrito,  Distrito, idProvincia ");
        sql.append(" FROM " + table);
        sql.append(" where idDistrito = ?");

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idDistrito);

        Cursor result = connection.rawQuery(sql.toString(), parameters);

        if (result.getCount() > 0) {
            result.moveToFirst();

            distrito.setIdDistrito(result.getInt(result.getColumnIndexOrThrow("idDistrito")));
            distrito.setDistrito(result.getString(result.getColumnIndexOrThrow("Distrito")));
            int idProvincia = result.getInt(result.getColumnIndexOrThrow("idProvincia"));
            distrito.setProvincia(provinciaRepository.get(idProvincia));
            return distrito;
        }
        return null;
    }
}
