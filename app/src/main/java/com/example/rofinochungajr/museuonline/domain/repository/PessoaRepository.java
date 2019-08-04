package com.example.rofinochungajr.museuonline.domain.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rofinochungajr.museuonline.domain.model.MetodoDePreservacao;
import com.example.rofinochungajr.museuonline.domain.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepository {
    private SQLiteDatabase connection;
    private static  final String table="pessoa";

    public PessoaRepository(SQLiteDatabase connection) {
        this.connection = connection;
    }

    public long insert(Pessoa pessoa) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("Nome", pessoa.getNome());
        return connection.insertOrThrow(table, null, contentValues);
    }

    public void delete(int idPessoa) {
        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idPessoa);

        connection.delete(table, "idPessoa = ?", parameters);
    }

    public void update(Pessoa pessoa) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("Nome", pessoa.getNome());
        String[] parameters = new String[1];
        parameters[0] = String.valueOf(pessoa.getNome());

        connection.update(table, contentValues, "idPessoa = ?", parameters);
    }



    public List<Pessoa> getAll() {

        List<Pessoa> pessoaList = new ArrayList<Pessoa>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idPessoa,  Nome ");
        sql.append(" FROM "+table);

        Cursor result = connection.rawQuery(sql.toString(), null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                Pessoa pessoa = new Pessoa();

                pessoa.setIdPessoa(result.getInt(result.getColumnIndexOrThrow("idPessoa")));
                pessoa.setNome(result.getString(result.getColumnIndexOrThrow("Nome")));
                pessoaList.add(pessoa);

            } while (result.moveToNext());

        }
        return pessoaList;
    }

    public Pessoa get(int idPessoa) {

        Pessoa pessoa = new Pessoa();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idPessoa,  Nome ");
        sql.append(" FROM "+table);
        sql.append(" where idPessoa = ?");

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idPessoa);

        Cursor result = connection.rawQuery(sql.toString(), parameters);

        if (result.getCount() > 0) {
            result.moveToFirst();
            pessoa.setIdPessoa(result.getInt(result.getColumnIndexOrThrow("idPessoa")));
            pessoa.setNome(result.getString(result.getColumnIndexOrThrow("Nome")));
            return pessoa;
        }
        return null;
    }
}
