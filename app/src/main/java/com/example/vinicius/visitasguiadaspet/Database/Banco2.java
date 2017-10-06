package com.example.vinicius.visitasguiadaspet.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vinicius on 06/10/17.
 */

public class Banco2 extends SQLiteOpenHelper {
    public Banco2(Context context){

        super(context, "HORARIOS", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( ScriptBanco.getCreateHorarios() );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
