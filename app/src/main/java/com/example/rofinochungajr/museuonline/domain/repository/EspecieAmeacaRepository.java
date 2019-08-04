package com.example.rofinochungajr.museuonline.domain.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rofinochungajr.museuonline.domain.model.Ameaca;
import com.example.rofinochungajr.museuonline.domain.model.Distrito;
import com.example.rofinochungajr.museuonline.domain.model.Especie;
import com.example.rofinochungajr.museuonline.domain.model.EspecieAmeaca;

import java.util.ArrayList;
import java.util.List;

public class EspecieAmeacaRepository {
    private SQLiteDatabase connection;
    private EspecieRepository especieRepository;
    private AmeacasRepository ameacasRepository;
    private static  final String table="ameacaEspecie";

    public EspecieAmeacaRepository(SQLiteDatabase connection) {
        this.connection = connection;
        this.ameacasRepository=new AmeacasRepository(connection);
        this.especieRepository=new EspecieRepository(connection);
    }

    public void insert(EspecieAmeaca especieAmeaca){
        ContentValues contentValues=new ContentValues();
        contentValues.put("idEspecie",especieAmeaca.getEspecie().getIdEspecie());
        contentValues.put("idAmeaca",especieAmeaca.getAmeaca().getIdAmeaca());

        connection.insertOrThrow(table,null,contentValues);
    }

    public void update(EspecieAmeaca especieAmeaca){
        ContentValues contentValues=new ContentValues();
        contentValues.put("idEspecie",especieAmeaca.getEspecie().getIdEspecie());
        contentValues.put("idAmeaca",especieAmeaca.getAmeaca().getIdAmeaca());

        String[] parameters = new String[2];
        parameters[0] = String.valueOf(especieAmeaca.getEspecie().getIdEspecie());
        parameters[1]=String.valueOf(especieAmeaca.getAmeaca().getIdAmeaca());


        connection.update(table, contentValues, "idEspecie = ? and idAmeaca = ?", parameters);

    }

    public void delete(EspecieAmeaca especieAmeaca){
            String[] parameters = new String[2];
            parameters[0] = String.valueOf(especieAmeaca.getEspecie().getIdEspecie());
            parameters[1]=String.valueOf(especieAmeaca.getAmeaca().getIdAmeaca());

            connection.delete(table, "idEspecie = ? and idAmeaca = ?", parameters);
    }

    public List<EspecieAmeaca> getAll(){
        List<EspecieAmeaca> especieAmeacaList=new ArrayList<EspecieAmeaca>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idEspecie,  idAmeaca ");
        sql.append(" FROM "+table);

        Cursor result = connection.rawQuery(sql.toString(), null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                EspecieAmeaca especieAmeaca = new EspecieAmeaca();

                Integer idEspecie=result.getInt(result.getInt(result.getColumnIndexOrThrow("idEspecie")));
                Integer idAmeaca=result.getInt(result.getColumnIndexOrThrow("idAmeaca"));

                especieAmeaca.setAmeaca(ameacasRepository.get(idAmeaca));
                especieAmeaca.setEspecie(especieRepository.get(idEspecie));
                especieAmeacaList.add(especieAmeaca);

            } while (result.moveToNext());

        }
        return especieAmeacaList;

    }

    public EspecieAmeaca get(Integer idEspecie,Integer idAmeaca){

        EspecieAmeaca especieAmeaca = new EspecieAmeaca();

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT idEspecie,  idAmeaca");
        sql.append(" FROM "+table);
        sql.append(" WHERE idEspecie = ? AND idAmeaca = ? ");

        String[] parameters = new String[2];
        parameters[0] = String.valueOf(idEspecie);
        parameters[1] =String.valueOf(idAmeaca);

        Cursor result = connection.rawQuery(sql.toString(), parameters);

        if (result.getCount() > 0) {
            result.moveToFirst();

            Integer especie=result.getInt(result.getInt(result.getColumnIndexOrThrow("idEspecie")));
            Integer ameaca=result.getInt(result.getColumnIndexOrThrow("idAmeaca"));

            especieAmeaca.setAmeaca(ameacasRepository.get(ameaca));
            especieAmeaca.setEspecie(especieRepository.get(especie));

            return especieAmeaca;
        }
        return null;
    }

}
