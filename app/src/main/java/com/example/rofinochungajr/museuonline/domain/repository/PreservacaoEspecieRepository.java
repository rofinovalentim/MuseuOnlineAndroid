package com.example.rofinochungajr.museuonline.domain.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rofinochungajr.museuonline.domain.model.Distrito;
import com.example.rofinochungajr.museuonline.domain.model.MetodoDePreservacao;
import com.example.rofinochungajr.museuonline.domain.model.PreservacaoEspecie;

import java.util.ArrayList;
import java.util.List;

public class PreservacaoEspecieRepository {


    private static final String table = "preservacaoespecie";
    private EspecieRepository especieRepository;
    private MetodoPreservacaoRepository metodoPreservacaoRepository;

    private SQLiteDatabase connection;

    public PreservacaoEspecieRepository(SQLiteDatabase connection) {
        this.connection = connection;
        this.especieRepository = new EspecieRepository(connection);
        this.metodoPreservacaoRepository = new MetodoPreservacaoRepository(connection);
    }

    public long insert(PreservacaoEspecie preservacaoEspecie) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("idEspecie", preservacaoEspecie.getEspecie().getIdEspecie());
        contentValues.put("idMetodoDePreservacao", preservacaoEspecie.getMetodoDePreservacao().getIdMetodo());

        return connection.insertOrThrow(table, null, contentValues);
    }

    public void update(PreservacaoEspecie preservacaoEspecie) {

        ContentValues contentValues = new ContentValues();

        contentValues.put("idEspecie", preservacaoEspecie.getEspecie().getIdEspecie());
        contentValues.put("idMetodoDePreservacao", preservacaoEspecie.getMetodoDePreservacao().getIdMetodo());

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(preservacaoEspecie.getIdPreservacaoEspecie());

        connection.update(table, contentValues, "idPreservacaoEspecie = ?", parameters);

    }

    public void delete(Integer idPreservacaoEspecie) {
        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idPreservacaoEspecie);

        connection.delete(table, "idPreservacaoEspecie = ?", parameters);
    }


    public List<PreservacaoEspecie> getAll() {

        List<PreservacaoEspecie> preservacaoEspecieList = new ArrayList<PreservacaoEspecie>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idPreservacaoEspecie,  idMetodoDePreservacao, idEspecie ");
        sql.append(" FROM " + table);

        Cursor result = connection.rawQuery(sql.toString(), null);

        if (result.getCount() > 0) {
            result.moveToFirst();

            do {
                PreservacaoEspecie preservacaoEspecie = new PreservacaoEspecie();

                Integer idMetodoPreservacao = result.getInt(result.getColumnIndexOrThrow("idMetodoDePreservacao"));
                Integer idEspecie = result.getInt(result.getColumnIndexOrThrow("idEspecie"));

                preservacaoEspecie.setIdPreservacaoEspecie(result.getInt(result.getColumnIndexOrThrow("idPreservacaoEspecie")));
                preservacaoEspecie.setEspecie(especieRepository.get(idEspecie));
                preservacaoEspecie.setMetodoDePreservacao(metodoPreservacaoRepository.get(idMetodoPreservacao));

                preservacaoEspecieList.add(preservacaoEspecie);

            } while (result.moveToNext());

        }
        return preservacaoEspecieList;
    }

    public PreservacaoEspecie get(int idPreservacaoEspecie) {

        PreservacaoEspecie preservacaoEspecie = new PreservacaoEspecie();

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT idPreservacaoEspecie,  idMetodoDePreservacao, idEspecie ");
        sql.append(" FROM " + table);
        sql.append(" WHERE idPreservacaoEspecie = ?");

        String[] parameters = new String[1];
        parameters[0] = String.valueOf(idPreservacaoEspecie);

        Cursor result = connection.rawQuery(sql.toString(), parameters);

        if (result.getCount() > 0) {
            result.moveToFirst();
            Integer idMetodoPreservacao = result.getInt(result.getColumnIndexOrThrow("idMetodoDePreservacao"));
            Integer idEspecie = result.getInt(result.getColumnIndexOrThrow("idEspecie"));

            preservacaoEspecie.setIdPreservacaoEspecie(result.getInt(result.getColumnIndexOrThrow("idPreservacaoEspecie")));
            preservacaoEspecie.setEspecie(especieRepository.get(idEspecie));
            preservacaoEspecie.setMetodoDePreservacao(metodoPreservacaoRepository.get(idMetodoPreservacao));
            return preservacaoEspecie;
        }
        return null;
    }
}
