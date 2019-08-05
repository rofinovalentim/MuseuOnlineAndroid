package com.example.rofinochungajr.museuonline.domain.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rofinochungajr.museuonline.domain.model.Genero;
import com.example.rofinochungajr.museuonline.domain.model.TipoUtilizador;

import java.util.ArrayList;
import java.util.List;

public class GeneroRepository {
    private FamiliaRepository familiaRepository;
    private SQLiteDatabase connection;
    private static final String table="genero";


    public GeneroRepository(SQLiteDatabase connection) {
        this.connection = connection;
        this.familiaRepository=new FamiliaRepository(connection);
    }


    public void insert(Genero genero) {
        ContentValues contentValues = new ContentValues();


        contentValues.put("Genero", genero.getGenero());
        contentValues.put("idFamilia",genero.getFamilia().getIdFamilia());

        connection.insertOrThrow(table, null, contentValues);

    }

    /*public void delete(int idTipoUtilizador) {
        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idTipoUtilizador);

        connection.delete("tipoutilizador", "idtipoutilizador = ?", parameters);
    }*/

   /* public void update(TipoUtilizador tipoUtilizador) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("idtipoutilizador", tipoUtilizador.getIdTipoUtilizador());
        contentValues.put("tipoutilizador", tipoUtilizador.getTipoUtilizador());
        //contentValues.put("idtipoutilizador", user.getTipoUtilizador().getIdTipoUtilizador());

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(tipoUtilizador.getIdTipoUtilizador());


        connection.update("tipoutilizador", contentValues, "idtipoutilizador = ?", parameters);

    }
*/
    public List<Genero> getAll() {

        List<Genero> generoList = new ArrayList<Genero>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idGenero,  Genero, idFamilia ");
        sql.append(" FROM "+table);

        Cursor result = connection.rawQuery(sql.toString(), null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                Genero genero = new Genero();

                genero.setIdGenero(result.getInt(result.getColumnIndexOrThrow("idGenero")));
                genero.setGenero(result.getString(result.getColumnIndexOrThrow("Genero")));
                Integer idFamilia=result.getInt(result.getColumnIndexOrThrow("idFamilia"));
                genero.setFamilia(familiaRepository.get(idFamilia));
               /* utilizador.setPassword(result.getString(result.getColumnIndexOrThrow("Senha")));
                utilizador.getTipoUtilizador().setIdTipoUtilizador(result.getInt(result.getColumnIndexOrThrow("idtipoutilizador")));
                */

                generoList.add(genero);

            } while (result.moveToNext());

        }
        return generoList;
    }

    public Genero get(int idGenero) {

        Genero genero = new Genero();

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT idGenero,  Genero, idFamilia ");
        sql.append(" FROM "+table);
        sql.append(" where idGenero = ?");

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idGenero);

        Cursor result = connection.rawQuery(sql.toString(), parameters);

        if (result.getCount() > 0) {
            result.moveToFirst();

            genero.setIdGenero(result.getInt(result.getColumnIndexOrThrow("idGenero")));
            genero.setGenero(result.getString(result.getColumnIndexOrThrow("Genero")));
            Integer idFamilia=result.getInt(result.getColumnIndexOrThrow("idFamilia"));
            genero.setFamilia(familiaRepository.get(idFamilia));

            return genero;
        }
        return null;
    }
}
