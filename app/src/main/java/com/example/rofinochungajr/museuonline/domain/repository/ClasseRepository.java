package com.example.rofinochungajr.museuonline.domain.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rofinochungajr.museuonline.domain.model.Classe;

import java.util.ArrayList;
import java.util.List;

public class ClasseRepository {
    private SQLiteDatabase connection;
    private FiloRepository filoRepository;
    private static final String table="classe";

    public ClasseRepository(SQLiteDatabase connection){
        this.connection=connection;
        this.filoRepository=new FiloRepository(connection);
    }

    public long insert(Classe classe){
        ContentValues contentValues=new ContentValues();

        contentValues.put("Classe",classe.getClasse());
        contentValues.put("idFilo",classe.getFilo().getIdFilo());

        return connection.insertOrThrow(table,null,contentValues);
    }

    public void update(Classe classe){
        ContentValues contentValues=new ContentValues();

        contentValues.put("Classe",classe.getClasse());
        contentValues.put("idFilo",classe.getFilo().getIdFilo());

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(classe.getIdClasse());


        connection.update(table, contentValues, "idClasse = ?", parameters);

    }

    public void delete(Integer idClasse){
        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idClasse);

        connection.delete(table, "idClasse = ?", parameters);

    }

    public List<Classe> getAll(){


        List<Classe> classeList=new ArrayList<>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idClasse,  Classe, idFilo ");
        sql.append(" FROM " + table);

        Cursor result = connection.rawQuery(sql.toString(), null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                Classe classe = new Classe();

                classe.setIdClasse(result.getInt(result.getColumnIndexOrThrow("idClasse")));
                classe.setClasse(result.getString(result.getColumnIndexOrThrow("Classe")));
                Integer idFilo=result.getInt(result.getColumnIndexOrThrow("idFilo"));
                classe.setFilo(filoRepository.get(idFilo));
                classeList.add(classe);

            } while (result.moveToNext());

        }
        return classeList;
    }

    public Classe get(Integer idClasse){
        Classe classe = new Classe();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idClasse,  Classe, idFilo ");
        sql.append(" FROM " + table);
        sql.append(" where idClasse = ?");

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idClasse);

        Cursor result = connection.rawQuery(sql.toString(), parameters);

        if (result.getCount() > 0) {
            result.moveToFirst();

            classe.setIdClasse(result.getInt(result.getColumnIndexOrThrow("idClasse")));
            classe.setClasse(result.getString(result.getColumnIndexOrThrow("Classe")));
            Integer idFilo=result.getInt(result.getColumnIndexOrThrow("idFilo"));
            classe.setFilo(filoRepository.get(idFilo));

            return classe;
        }
        return null;
    }

}
