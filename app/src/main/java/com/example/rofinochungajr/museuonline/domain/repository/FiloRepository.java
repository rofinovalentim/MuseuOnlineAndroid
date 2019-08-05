package com.example.rofinochungajr.museuonline.domain.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rofinochungajr.museuonline.domain.model.Filo;

import java.util.ArrayList;
import java.util.List;

public class FiloRepository {
    private static final String table="filo";
    private SQLiteDatabase connection;
    private ReinoRepository reinoRepository;

    public FiloRepository(SQLiteDatabase connection){
        this.connection=connection;
        this.reinoRepository=new ReinoRepository(connection);
    }

    public long insert(Filo filo){

        ContentValues contentValues=new ContentValues();

        contentValues.put("Filo",filo.getFilo());
        contentValues.put("idReino",filo.getReino().getIdReino());

       return connection.insertOrThrow(table,null,contentValues);
    }

    public void update (Filo filo){
        ContentValues contentValues=new ContentValues();

        contentValues.put("Filo",filo.getFilo());
        contentValues.put("idReino",filo.getReino().getIdReino());

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(filo.getIdFilo());

        connection.update(table, contentValues, "idFilo = ?", parameters);
    }

    public void delete(Integer idFilo){
        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idFilo);

        connection.delete(table, "idFilo = ?", parameters);
    }

    public List<Filo> getAll(){


        List<Filo> filoList=new ArrayList<>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idFilo,  Filo, idReino ");
        sql.append(" FROM " + table);

        Cursor result = connection.rawQuery(sql.toString(), null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                Filo filo = new Filo();

                filo.setIdFilo(result.getInt(result.getColumnIndexOrThrow("idFilo")));
                filo.setFilo(result.getString(result.getColumnIndexOrThrow("Filo")));
                Integer idReino=result.getInt(result.getColumnIndexOrThrow("idReino"));
                filo.setReino(reinoRepository.get(idReino));
                filoList.add(filo);

            } while (result.moveToNext());

        }
        return filoList;
    }

    public Filo get(Integer idFilo){
        Filo filo = new Filo();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idFilo,  Filo, idReino ");
        sql.append(" FROM " + table);
        sql.append(" where idFilo = ?");

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idFilo);

        Cursor result = connection.rawQuery(sql.toString(), parameters);

        if (result.getCount() > 0) {
            result.moveToFirst();
            filo.setIdFilo(result.getInt(result.getColumnIndexOrThrow("idFilo")));
            filo.setFilo(result.getString(result.getColumnIndexOrThrow("Filo")));
            Integer idReino=result.getInt(result.getColumnIndexOrThrow("idReino"));
            filo.setReino(reinoRepository.get(idReino));
            return filo;
        }
        return null;
    }

}
