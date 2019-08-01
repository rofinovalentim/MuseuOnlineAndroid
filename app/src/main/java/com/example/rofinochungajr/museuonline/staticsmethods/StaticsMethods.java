package com.example.rofinochungajr.museuonline.staticsmethods;

import android.app.AlertDialog;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Patterns;

import com.example.rofinochungajr.museuonline.R;
import com.example.rofinochungajr.museuonline.database.DataBaseOpenHelper;

public class StaticsMethods {


    public static SQLiteDatabase createConnectionDB(Context context) {
        try {
            DataBaseOpenHelper dataBaseOpenHelper = new DataBaseOpenHelper(context);
            SQLiteDatabase  connection = dataBaseOpenHelper.getWritableDatabase();
            return connection;
        } catch (SQLException ex) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(context);

            dlg.setTitle(R.string.title_aviso);
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton(R.string.msg_ok, null);
            return null;
        }
    }
    public static boolean isEmpty(String value) {
        boolean result = (TextUtils.isEmpty(value) || value.trim().isEmpty());

        return result;
    }

    public static boolean isValidEmail(String email) {
        boolean result = Patterns.EMAIL_ADDRESS.matcher(email).matches();
        return result;
    }
}
