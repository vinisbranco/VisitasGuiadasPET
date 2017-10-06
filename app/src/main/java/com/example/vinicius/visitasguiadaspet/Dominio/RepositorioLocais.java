package com.example.vinicius.visitasguiadaspet.Dominio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.vinicius.visitasguiadaspet.Dominio.Entidades.Locais;

/**
 * Created by vinicius on 28/09/17.
 */

public class RepositorioLocais {

    private SQLiteDatabase conn;
    private ListView lstLocais;


    public RepositorioLocais(SQLiteDatabase conn){
        this.conn = conn;

    }
    public void inserir(Locais locais){
        ContentValues values = new ContentValues();

        values.put("id", locais.getId());
        values.put("nSala", locais.getnSala());
        values.put("nome", locais.getNome());
        values.put("numContato", locais.getNumContato());
        values.put("email", locais.getEmail());
        values.put("tempVisit", locais.getTempVisit());
        values.put("descricao", locais.getDescricao());

        conn.insertOrThrow("LOCAIS", null, values);

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