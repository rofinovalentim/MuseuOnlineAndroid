package com.example.rofinochungajr.museuonline.domain.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rofinochungajr.museuonline.domain.model.Distrito;
import com.example.rofinochungajr.museuonline.domain.model.LocalizacaoEspecie;
import com.example.rofinochungajr.museuonline.domain.model.Utilizador;

import java.util.ArrayList;
import java.util.List;

public class LocalizacaoEspecieRepository {

    private SQLiteDatabase connection;
    private static final  String table="localizacaoespecie";

    private DistritoRepository distritoRepository;
    private ProvinciaRepository provinciaRepository;
    private RegiaoRepository regiaoRepository;
    private EspecieRepository especieRepository;

    public LocalizacaoEspecieRepository(SQLiteDatabase connection) {
        this.connection = connection;
        this.distritoRepository=new DistritoRepository(connection);
        this.provinciaRepository=new ProvinciaRepository(connection);
        this.especieRepository=new EspecieRepository(connection);
    }


    public void insert(LocalizacaoEspecie localizacaoEspecie) {
        ContentValues contentValues = new ContentValues();

       // contentValues.put("idLocalizacao", localizacaoEspecie.getIdLocalizacao().getEmail());
        contentValues.put("idDistrito",localizacaoEspecie.getDistrito().getIdDistrito());
        contentValues.put("idProvincia",localizacaoEspecie.getProvincia().getIdProvicia());
        contentValues.put("idRegiao", localizacaoEspecie.getRegiao().getIdRegiao());
        contentValues.put("idEspecie", localizacaoEspecie.getRegiao().getIdRegiao());

        connection.insertOrThrow(table, null, contentValues);

    }

    public void delete(Integer idLocalizacao) {
        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idLocalizacao);

        connection.delete(table, "idLocalizacao = ?", parameters);
    }

    public void update(LocalizacaoEspecie localizacaoEspecie) {
        ContentValues contentValues = new ContentValues();

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(localizacaoEspecie.getIdLocalizacao());

        // contentValues.put("idLocalizacao", localizacaoEspecie.getIdLocalizacao().getEmail());
        contentValues.put("idDistrito",localizacaoEspecie.getDistrito().getIdDistrito());
        contentValues.put("idProvincia",localizacaoEspecie.getProvincia().getIdProvicia());
        contentValues.put("idRegiao", localizacaoEspecie.getRegiao().getIdRegiao());
        contentValues.put("idEspecie", localizacaoEspecie.getRegiao().getIdRegiao());



        connection.update(table, contentValues, "idLocalizacao = ?", parameters);

    }

    public List<LocalizacaoEspecie> getAll() {

        List<LocalizacaoEspecie> localizacaoEspecieList = new ArrayList<LocalizacaoEspecie>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idLocalizacao,  idDistrito, idEspecie, idProvincia, idRegiao ");
        sql.append(" FROM "+table);

        Cursor result = connection.rawQuery(sql.toString(), null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                LocalizacaoEspecie localizacaoEspecie = new LocalizacaoEspecie();



                //distrito.setDistrito(result.getString(result.getColumnIndexOrThrow("Distrito")));
                Integer idProvincia=result.getInt(result.getColumnIndexOrThrow("idProvincia"));
                Integer idDistrito=result.getInt(result.getColumnIndexOrThrow("idDistrito"));
                Integer idEspecie=result.getInt(result.getColumnIndexOrThrow("idEspecie"));
                Integer idRegiao=result.getInt(result.getColumnIndexOrThrow("idRegiao"));

                localizacaoEspecie.setIdLocalizacao(result.getInt(result.getColumnIndexOrThrow("idLocalizacao")));
                localizacaoEspecie.setDistrito(distritoRepository.get(idDistrito));
                localizacaoEspecie.setEspecie(especieRepository.getOne(idEspecie));
                localizacaoEspecie.setRegiao(regiaoRepository.get(idRegiao));
                localizacaoEspecie.setProvincia(provinciaRepository.get(idProvincia));


                localizacaoEspecieList.add(localizacaoEspecie);

            } while (result.moveToNext());

        }
        return localizacaoEspecieList;
    }

    /*public List<LocalizacaoEspecie> getDistritoByProvincia(int idProvincia){

        List<Distrito> distritoList = new ArrayList<Distrito>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idDistrito,  Distrito, idProvincia ");
        sql.append(" FROM "+table);

        sql.append(" where idProvincia = ?");

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idProvincia);

        Cursor result = connection.rawQuery(sql.toString(), parameters);

        //Cursor result = connection.rawQuery(sql.toString(), null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                Distrito distrito = new Distrito();

                distrito.setIdDistrito(result.getInt(result.getColumnIndexOrThrow("idDistrito")));
                distrito.setDistrito(result.getString(result.getColumnIndexOrThrow("Distrito")));
                //int idProvincia=result.getInt(result.getColumnIndexOrThrow("idProvincia"));
                distrito.setProvincia(provinciaRepository.get(idProvincia));

                distritoList.add(distrito);

            } while (result.moveToNext());

        }
        return distritoList;
    }
*/
    public LocalizacaoEspecie get(Integer idLocalizacao) {

        LocalizacaoEspecie localizacaoEspecie = new LocalizacaoEspecie();

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT idLocalizacao,  idDistrito, idEspecie, idProvincia, idRegiao ");
        sql.append(" FROM "+table);
        sql.append(" where idLocalizacao = ?");

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idLocalizacao);

        Cursor result = connection.rawQuery(sql.toString(), parameters);

        if (result.getCount() > 0) {
            result.moveToFirst();
           // LocalizacaoEspecie localizacaoEspecie = new LocalizacaoEspecie();



            //distrito.setDistrito(result.getString(result.getColumnIndexOrThrow("Distrito")));
            Integer idProvincia=result.getInt(result.getColumnIndexOrThrow("idProvincia"));
            Integer idDistrito=result.getInt(result.getColumnIndexOrThrow("idDistrito"));
            Integer idEspecie=result.getInt(result.getColumnIndexOrThrow("idEspecie"));
            Integer idRegiao=result.getInt(result.getColumnIndexOrThrow("idRegiao"));

            localizacaoEspecie.setIdLocalizacao(result.getInt(result.getColumnIndexOrThrow("idLocalizacao")));
            localizacaoEspecie.setDistrito(distritoRepository.get(idDistrito));
            localizacaoEspecie.setEspecie(especieRepository.getOne(idEspecie));
            localizacaoEspecie.setRegiao(regiaoRepository.get(idRegiao));
            localizacaoEspecie.setProvincia(provinciaRepository.get(idProvincia));
            return localizacaoEspecie;
        }
        return null;
    }
}
