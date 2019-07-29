package com.example.rofinochungajr.museuonline.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;


public class DataBaseOpenHelper extends SQLiteOpenHelper {

    public DataBaseOpenHelper(@Nullable Context context) {
        super(context, "database", null, 3);
        //this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableTipoUtilizador());
        /*sqLiteDatabase.execSQL(ScriptDDL.getCreateTableUtilizador());
        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableReino());
        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableFilo());
        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableClasse());
        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableOrdem());
        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableFamilia());
        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableGenero());
        */
        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableEspecie());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
