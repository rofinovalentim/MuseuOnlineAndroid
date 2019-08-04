package com.example.rofinochungajr.museuonline.domain.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rofinochungajr.museuonline.domain.model.Utilizador;

import java.util.ArrayList;
import java.util.List;

public class UtilizadorRepository {

    private SQLiteDatabase connection;
    private TipoUtilizadorRepository tipoUtilizadorRepository;


    public UtilizadorRepository(SQLiteDatabase connection) {
        this.connection = connection;
        this.tipoUtilizadorRepository=new TipoUtilizadorRepository(connection);
    }

    public void insert(Utilizador user) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("nomeCompleto",user.getNomeCompleto());
        contentValues.put("email", user.getEmail());
        contentValues.put("Senha", user.getPassword());
        contentValues.put("idtipoutilizador", user.getTipoUtilizador().getIdTipoUtilizador());

        connection.insertOrThrow("utilizador", null, contentValues);
    }

    public void delete(int idUtilizador) {
        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idUtilizador);

        connection.delete("utilizador", "idUtiizador = ?", parameters);
    }

    public void update(Utilizador user) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("nomeCompleto",user.getNomeCompleto());
        contentValues.put("email", user.getEmail());
        contentValues.put("Senha", user.getPassword());
        contentValues.put("idtipoutilizador", user.getTipoUtilizador().getIdTipoUtilizador());

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(user.getIdUtilizador());


        connection.update("utilizador", contentValues, "idUtiizador = ?", parameters);

    }

    public List<Utilizador> getAll() {

        List<Utilizador> utilizadorList = new ArrayList<Utilizador>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idUtilizador, nomeCompleto, email, Senha, idtipoutilizador");
        sql.append(" FROM utilizador");

        Cursor result = connection.rawQuery(sql.toString(), null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                Utilizador utilizador = new Utilizador();

                utilizador.setIdUtilizador(result.getInt(result.getColumnIndexOrThrow("idUtilizador")));
                utilizador.setNomeCompleto(result.getString(result.getColumnIndexOrThrow("nomeCompleto")));
                utilizador.setEmail(result.getString(result.getColumnIndexOrThrow("email")));
                utilizador.setPassword(result.getString(result.getColumnIndexOrThrow("Senha")));
                int idTipoUtilizador=result.getInt(result.getColumnIndexOrThrow("idtipoutilizador"));
                utilizador.setTipoUtilizador(tipoUtilizadorRepository.getTipoUtilizador(idTipoUtilizador));

                utilizadorList.add(utilizador);

            } while (result.moveToNext());

        }
        return utilizadorList;
    }

    public Utilizador getUtilizador(int idUtilizador) {

        Utilizador utilizador = new Utilizador();

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT idUtilizador, nomeCompleto, email, Senha, idtipoutilizador");
        sql.append(" FROM utilizador");
        sql.append(" where idUtilizador = ?");

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idUtilizador);

        Cursor result = connection.rawQuery(sql.toString(), parameters);

        if (result.getCount() > 0) {
            result.moveToFirst();

            utilizador.setIdUtilizador(result.getInt(result.getColumnIndexOrThrow("idUtilizador")));
            utilizador.setNomeCompleto(result.getString(result.getColumnIndexOrThrow("nomeCompleto")));
            utilizador.setEmail(result.getString(result.getColumnIndexOrThrow("email")));
            utilizador.setPassword(result.getString(result.getColumnIndexOrThrow("Senha")));
            int idTipoUtilizador =result.getInt(result.getColumnIndexOrThrow("idtipoutilizador"));
            utilizador.setTipoUtilizador(tipoUtilizadorRepository.getTipoUtilizador(idTipoUtilizador));
            return utilizador;
        }

        return null;
    }


    public Utilizador getUtilizadorByEmail(String email) {

        Utilizador utilizador = new Utilizador();

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT idUtilizador, nomeCompleto, email, Senha, idtipoutilizador");
        sql.append(" FROM utilizador");
        sql.append(" where email = ?");

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(email);

        Cursor result = connection.rawQuery(sql.toString(), parameters);

        if (result.getCount() > 0) {
            result.moveToFirst();

            utilizador.setIdUtilizador(result.getInt(result.getColumnIndexOrThrow("idUtilizador")));
            utilizador.setNomeCompleto(result.getString(result.getColumnIndexOrThrow("nomeCompleto")));
            utilizador.setEmail(result.getString(result.getColumnIndexOrThrow("email")));
            utilizador.setPassword(result.getString(result.getColumnIndexOrThrow("Senha")));
            int idTipoUtilizador =result.getInt(result.getColumnIndexOrThrow("idtipoutilizador"));
            utilizador.setTipoUtilizador(tipoUtilizadorRepository.getTipoUtilizador(idTipoUtilizador));
            return utilizador;
        }

        return null;
    }
}
