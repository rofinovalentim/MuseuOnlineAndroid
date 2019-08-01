package com.example.rofinochungajr.museuonline.domain.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rofinochungajr.museuonline.domain.model.Especie;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EspecieRepository {

    private SQLiteDatabase connection;
    private static final String table="especie";




    public EspecieRepository(SQLiteDatabase connection) {
        this.connection = connection;
    }


    public void insert(Especie especie){


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate=new Date();
        String formatedDate= dateFormat.format(currentDate);


        ContentValues contentValues=new ContentValues();


        contentValues.put("Especie",especie.getNomeEspecie());
      //  contentValues.put("idGenero",especie.getGenero().getIdGenero());
        contentValues.put("Habitat",especie.getHabitat());
        contentValues.put("Coordenadas",especie.getCoordenadas());
        contentValues.put("Notas",especie.getNotas());
        contentValues.put("detalhes",especie.getDetalhes());
        contentValues.put("NomeComum",especie.getNomeComum());
        contentValues.put("Codigo",especie.getCodigo());
        contentValues.put("Validacao",especie.getValidacao());
        contentValues.put("detalhes",especie.getDetalhes());
        contentValues.put("DataCriacao",formatedDate);

        connection.insertOrThrow(table,null,contentValues);

    }

    public void update(Especie especie){
        ContentValues contentValues=new ContentValues();

        contentValues.put("Especie",especie.getNomeEspecie());
        contentValues.put("idGenero",especie.getGenero().getIdGenero());
        contentValues.put("Habitat",especie.getHabitat());
        contentValues.put("Coordenadas",especie.getCoordenadas());
        contentValues.put("Notas",especie.getNotas());
        contentValues.put("detalhes",especie.getDetalhes());
        contentValues.put("NomeComum",especie.getNomeComum());
        contentValues.put("Codigo",especie.getCodigo());
        contentValues.put("Validacao",especie.getValidacao());
        contentValues.put("DataCriacao",especie.getDataCriacao());

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(especie.getIdEspecie());

        connection.update(table,contentValues,"idEspecie = ?",parameters);

    }

    public void delete(int idEspecie){
        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idEspecie);

        connection.delete(table, "idEspecie = ?", parameters);
    }

    public List<Especie> getAll(){
        List<Especie> especieList = new ArrayList<Especie>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao ");
        sql.append(" FROM "+table);

        Cursor result = connection.rawQuery(sql.toString(), null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                Especie especie = new Especie();

                especie.setIdEspecie(result.getInt(result.getColumnIndexOrThrow("idEspecie")));
                especie.setNomeEspecie(result.getString(result.getColumnIndexOrThrow("Especie")));
                especie.setHabitat(result.getString(result.getColumnIndexOrThrow("Habitat")));
                especie.setCoordenadas(result.getString(result.getColumnIndexOrThrow("Coordenadas")));
                especie.setNotas(result.getString(result.getColumnIndexOrThrow("Notas")));
                especie.setDetalhes(result.getString(result.getColumnIndexOrThrow("detalhes")));
                especie.setNomeComum(result.getString(result.getColumnIndexOrThrow("NomeComum")));
                especie.setCodigo(result.getString(result.getColumnIndexOrThrow("Codigo")));
                especie.setValidacao(result.getString(result.getColumnIndexOrThrow("Validacao")));
                especie.setDataCriacao(result.getString(result.getColumnIndexOrThrow("DataCriacao")));
                //especie.setGenero();


                especieList.add(especie);

            } while (result.moveToNext());

        }
        return especieList;
    }

    public Especie getOne(int idEspecie){
        Especie especie = new Especie();

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT SELECT idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao ");
        sql.append(" FROM "+table);
        sql.append(" where idEspecie = ?");

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idEspecie);

        Cursor result = connection.rawQuery(sql.toString(), parameters);

        if (result.getCount() > 0) {
            result.moveToFirst();

            especie.setIdEspecie(result.getInt(result.getColumnIndexOrThrow("idEspecie")));
            especie.setNomeEspecie(result.getString(result.getColumnIndexOrThrow("Especie")));
            especie.setHabitat(result.getString(result.getColumnIndexOrThrow("Habitat")));
            especie.setCoordenadas(result.getString(result.getColumnIndexOrThrow("Coordenadas")));
            especie.setNotas(result.getString(result.getColumnIndexOrThrow("Notas")));
            especie.setDetalhes(result.getString(result.getColumnIndexOrThrow("detalhes")));
            especie.setNomeComum(result.getString(result.getColumnIndexOrThrow("NomeComum")));
            especie.setCodigo(result.getString(result.getColumnIndexOrThrow("Validacao")));
            especie.setDataCriacao(result.getString(result.getColumnIndexOrThrow("DataCriacao")));
        //  especie.setGenero();

            return especie;
        }
        return null;
    }

}


