package com.example.vinicius.visitasguiadaspet.Dominio;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by vinicius on 28/09/17.
 */

public class RepositorioLocais {

    private SQLiteDatabase conn;
    private ListView lstLocais;


    public RepositorioLocais(SQLiteDatabase conn){
        this.conn = conn;

    }

    public ArrayAdapter<String> buscaLocais(Context context){

        ArrayAdapter<String> adpLocais = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);

        Cursor cursor = conn.query("LOCAIS", null, null, null, null, null, null);



        if(cursor.getCount() > 0){
            do {
                String numsala = cursor.getString(2);
                adpLocais.add(numsala);
            }while(cursor.moveToNext());


        }
        return adpLocais;
    }
}