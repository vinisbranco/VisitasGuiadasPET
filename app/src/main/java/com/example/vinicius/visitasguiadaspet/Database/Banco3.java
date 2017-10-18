package com.example.vinicius.visitasguiadaspet.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vinicius on 11/10/17.
 */

public class Banco3 extends SQLiteOpenHelper{
    public Banco3(Context context){

        super(context, "TAGS", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( ScriptBanco.getCreateTags() );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
