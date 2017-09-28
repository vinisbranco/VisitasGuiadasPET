package com.example.vinicius.visitasguiadaspet.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vinicius on 28/09/17.
 */

public class Banco extends SQLiteOpenHelper {

    public Banco(Context context){

        super(context, "LOCAIS", null, 1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( ScriptBanco.getCreateLocal() );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
