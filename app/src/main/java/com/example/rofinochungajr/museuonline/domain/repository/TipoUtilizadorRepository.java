package com.example.rofinochungajr.museuonline.domain.repository;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.rofinochungajr.museuonline.domain.model.TipoUtilizador;

public class TipoUtilizadorRepository {


    private SQLiteDatabase connection;


    public TipoUtilizadorRepository(SQLiteDatabase connection) {
        this.connection = connection;
    }


    public void insert(TipoUtilizador tipoUtilizador) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("idtipoutilizador", tipoUtilizador.getIdTipoUtilizador());
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

    /*public List<Utilizador> getAll() {

        List<Utilizador> utilizadorList = new ArrayList<Utilizador>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idUtilizador, email, Senha, idtipoutilizador");
        sql.append(" FROM utilizador");

        Cursor result = connection.rawQuery(sql.toString(), null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                Utilizador utilizador = new Utilizador();

                utilizador.setIdUtilizador(result.getInt(result.getColumnIndexOrThrow("idUtilizador")));
                utilizador.setEmail(result.getString(result.getColumnIndexOrThrow("email")));
                utilizador.setPassword(result.getString(result.getColumnIndexOrThrow("Senha")));
                utilizador.getTipoUtilizador().setIdTipoUtilizador(result.getInt(result.getColumnIndexOrThrow("idtipoutilizador")));

                utilizadorList.add(utilizador);

            } while (result.moveToNext());

        }
        return utilizadorList;
    }

    public Utilizador getUtilizador(int idUtilizador) {

        Utilizador utilizador = new Utilizador();

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT idUtilizador, email, Senha, idtipoutilizador");
        sql.append(" FROM utilizador");
        sql.append(" where idUtilizador = ?");

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idUtilizador);

        Cursor result = connection.rawQuery(sql.toString(), parameters);

        if (result.getCount() > 0) {
            result.moveToFirst();

            utilizador.setIdUtilizador(result.getInt(result.getColumnIndexOrThrow("idUtilizador")));
            utilizador.setEmail(result.getString(result.getColumnIndexOrThrow("email")));
            utilizador.setPassword(result.getString(result.getColumnIndexOrThrow("Senha")));
            utilizador.getTipoUtilizador().setIdTipoUtilizador(result.getInt(result.getColumnIndexOrThrow("idtipoutilizador")));

            return utilizador;
        }

        return null;
    }*/
}
