package com.example.rofinochungajr.museuonline.domain.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rofinochungajr.museuonline.domain.model.Familia;
import com.example.rofinochungajr.museuonline.domain.model.Ordem;

import java.util.ArrayList;
import java.util.List;

public class FamiliaRepository {
    private SQLiteDatabase connection;
    private OrdemRepository ordemRepository ;
    private static final String table="familia";

    public FamiliaRepository(SQLiteDatabase connection){
        this.connection=connection;
        this.ordemRepository=new OrdemRepository(connection);
    }

    public long insert(Familia familia){
        ContentValues contentValues=new ContentValues();

        contentValues.put("Familia",familia.getFamilia());
        contentValues.put("idOrdem",familia.getOrdem().getIdOrdem());

        return connection.insertOrThrow(table,null,contentValues);
    }

    public void update(Familia familia){
        ContentValues contentValues=new ContentValues();


        contentValues.put("Familia",familia.getFamilia());
        contentValues.put("idOrdem",familia.getOrdem().getIdOrdem());

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(familia.getIdFamilia());


        connection.update(table, contentValues, "idFamilia = ?", parameters);
    }

    public void delete(Integer idFamilia){
        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idFamilia);

        connection.delete(table, "idFamilia = ?", parameters);

    }

    public List<Familia> getAll(){


        List<Familia> familiaList =new ArrayList<>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idFamilia,  Familia, idOrdem ");
        sql.append(" FROM " + table);

        Cursor result = connection.rawQuery(sql.toString(), null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                Familia familia = new Familia();

                familia.setIdFamilia(result.getInt(result.getColumnIndexOrThrow("idFamilia")));
                familia.setFamilia(result.getString(result.getColumnIndexOrThrow("Familia")));
                Integer idOrdem=result.getInt(result.getColumnIndexOrThrow("idOrdem"));
                familia.setOrdem(ordemRepository.get(idOrdem));

                familiaList.add(familia);

            } while (result.moveToNext());

        }
        return familiaList;
    }

    public Familia get(Integer idFamilia){
        Familia familia = new Familia();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idFamilia,  Familia, idOrdem ");
        sql.append(" FROM " + table);
        sql.append(" where idFamilia = ?");

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idFamilia);

        Cursor result = connection.rawQuery(sql.toString(), parameters);

        if (result.getCount() > 0) {
            result.moveToFirst();

            familia.setIdFamilia(result.getInt(result.getColumnIndexOrThrow("idFamilia")));
            familia.setFamilia(result.getString(result.getColumnIndexOrThrow("Familia")));
            Integer idOrdem=result.getInt(result.getColumnIndexOrThrow("idOrdem"));
            familia.setOrdem(ordemRepository.get(idOrdem));

            return familia;
        }
        return null;
    }
}
