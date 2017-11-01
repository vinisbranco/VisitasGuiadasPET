package com.example.vinicius.visitasguiadaspet.Dominio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.vinicius.visitasguiadaspet.Dominio.Entidades.Locais;
import com.example.vinicius.visitasguiadaspet.Dominio.Entidades.Tags;

import java.util.HashMap;

/**
 * Created by vinicius on 11/10/17.
 */

public class RepositorioTags {

    private SQLiteDatabase conn;
    private ListView lstTags;
    private RepositorioLocais replocais;


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

    public HashMap<Integer, Tags> buscaTags(Context context){
        HashMap<Integer, Tags> map = new HashMap<>();
        //ArrayAdapter<Tags> adpTags = new ArrayAdapter<Tags>(context, android.R.layout.simple_list_item_1);

        Cursor cursor = conn.query("TAGS", null, null, null, null, null, null);



        if(cursor.getCount() > 0){
            do {

                HashMap<Integer, Locais> adpLocais = new HashMap<>();
                adpLocais = replocais.buscaLocais(context);
                Locais locais = new Locais();

                locais =  adpLocais.get(cursor.getInt(1));
                
                Tags tag = new Tags();
                tag.setLocais(locais);
                tag.setIdTags(cursor.getInt(2));
                tag.setTags(cursor.getString(3));

                map.put(cursor.getInt(2),tag);

            }while(cursor.moveToNext());


        }
        return map;
    }
}
