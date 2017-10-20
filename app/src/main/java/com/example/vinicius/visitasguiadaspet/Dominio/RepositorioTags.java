package com.example.vinicius.visitasguiadaspet.Dominio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.vinicius.visitasguiadaspet.Dominio.Entidades.Tags;

/**
 * Created by vinicius on 11/10/17.
 */

public class RepositorioTags {

    private SQLiteDatabase conn;
    private ListView lstTags;


    public RepositorioTags(SQLiteDatabase conn){
        this.conn = conn;

    }
    public void inserir(Tags tags){
        ContentValues values = new ContentValues();

        values.put("id", tags.getLocais().getId());
        values.put("idTag", tags.getIdTags());
        values.put("tag", tags.getTags());

        conn.insertOrThrow("TAGS", null, values);

    }

    public ArrayAdapter<Tags> buscaTags(Context context){

        ArrayAdapter<Tags> adpTags = new ArrayAdapter<Tags>(context, android.R.layout.simple_list_item_1);

        Cursor cursor = conn.query("TAGS", null, null, null, null, null, null);



        if(cursor.getCount() > 0){
            do {
                Tags tag = new Tags();
                tag.setTags(cursor.getString(3));
                adpTags.add(tag);
            }while(cursor.moveToNext());


        }
        return adpTags;
    }
}
