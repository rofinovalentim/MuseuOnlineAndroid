package com.example.rofinochungajr.museuonline.domain.repository;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rofinochungajr.museuonline.domain.model.Genero;
import com.example.rofinochungajr.museuonline.domain.model.Provincia;

import java.util.ArrayList;
import java.util.List;

public class ProvinciaRepository {
    private SQLiteDatabase connection;
    private RegiaoRepository regiaoRepository;


    public ProvinciaRepository(SQLiteDatabase connection) {
        this.connection = connection;
        this.regiaoRepository=new RegiaoRepository(connection);
    }

    public List<Provincia> getAll() {

        List<Provincia> provinciaList = new ArrayList<Provincia>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idProvincia,  Provincia, idRegiao ");
        sql.append(" FROM provincia");

        Cursor result = connection.rawQuery(sql.toString(), null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                Provincia provincia = new Provincia();

                provincia.setIdProvicia(result.getInt(result.getColumnIndexOrThrow("idProvincia")));
                provincia.setProvincia(result.getString(result.getColumnIndexOrThrow("Provincia")));
                int idRegiao=result.getInt(result.getColumnIndexOrThrow("idRegiao"));
                provincia.setRegiao(regiaoRepository.get(idRegiao));

                provinciaList.add(provincia);

            } while (result.moveToNext());

        }
        return provinciaList;
    }

    public Provincia get(int idProvincia) {

        Provincia provincia = new Provincia();

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT idProvincia,  Provincia, idRegiao ");
        sql.append(" FROM provincia");
        sql.append(" where idProvincia = ?");

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idProvincia);

        Cursor result = connection.rawQuery(sql.toString(), parameters);

        if (result.getCount() > 0) {
            result.moveToFirst();

            provincia.setIdProvicia(result.getInt(result.getColumnIndexOrThrow("idProvincia")));
            provincia.setProvincia(result.getString(result.getColumnIndexOrThrow("Provincia")));
            int idRegiao=result.getInt(result.getColumnIndexOrThrow("idRegiao"));
            provincia.setRegiao(regiaoRepository.get(idRegiao));

            return provincia;
        }
        return null;
    }
}
