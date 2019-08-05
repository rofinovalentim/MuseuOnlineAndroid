package com.example.rofinochungajr.museuonline.domain.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rofinochungajr.museuonline.domain.model.Ordem;

import java.util.ArrayList;
import java.util.List;

public class OrdemRepository {
    private SQLiteDatabase connection;
    private ClasseRepository classeRepository ;
    private static final String table="ordem";

    public OrdemRepository(SQLiteDatabase connection){
        this.connection=connection;
        this.classeRepository=new ClasseRepository(connection);
    }

    public long insert(Ordem ordem){
        ContentValues contentValues=new ContentValues();

        contentValues.put("Ordem",ordem.getOrdem());
        contentValues.put("idClasse",ordem.getClasse().getIdClasse());

        return connection.insertOrThrow(table,null,contentValues);
    }

    public void update(Ordem ordem){
        ContentValues contentValues=new ContentValues();

        contentValues.put("Ordem",ordem.getOrdem());
        contentValues.put("idClasse",ordem.getClasse().getIdClasse());

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(ordem.getIdOrdem());


        connection.update(table, contentValues, "idOrdem = ?", parameters);
    }

    public void delete(Integer idOrdem){
        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idOrdem);

        connection.delete(table, "idOrdem = ?", parameters);

    }

    public List<Ordem> getAll(){


        List<Ordem> ordemList=new ArrayList<>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idOrdem,  Ordem, idClasse ");
        sql.append(" FROM " + table);

        Cursor result = connection.rawQuery(sql.toString(), null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                Ordem ordem = new Ordem();

                ordem.setIdOrdem(result.getInt(result.getColumnIndexOrThrow("idOrdem")));
                ordem.setOrdem(result.getString(result.getColumnIndexOrThrow("Ordem")));
                Integer idClasse=result.getInt(result.getColumnIndexOrThrow("idClasse"));
                ordem.setClasse(classeRepository.get(idClasse));
                ordemList.add(ordem);

            } while (result.moveToNext());

        }
        return ordemList;
    }

    public Ordem get(Integer idOrdem){
        Ordem ordem = new Ordem();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idOrdem,  Ordem, idClasse ");
        sql.append(" FROM " + table);
        sql.append(" where idOrdem = ?");

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idOrdem);

        Cursor result = connection.rawQuery(sql.toString(), parameters);

        if (result.getCount() > 0) {
            result.moveToFirst();

            ordem.setIdOrdem(result.getInt(result.getColumnIndexOrThrow("idOrdem")));
            ordem.setOrdem(result.getString(result.getColumnIndexOrThrow("Ordem")));
            Integer idClasse=result.getInt(result.getColumnIndexOrThrow("idClasse"));
            ordem.setClasse(classeRepository.get(idClasse));

            return ordem;
        }
        return null;
    }
}
