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

    public HashMap<Integer, Locais> buscaLocais(){
        HashMap<Integer, Locais> maplocais = new HashMap<>();
        //ArrayAdapter<Locais> adpLocais = new ArrayAdapter<Locais>(context, android.R.layout.simple_list_item_1);

        Cursor cursor = conn.query("LOCAIS", null, null, null, null, null, null);



        if(cursor.getCount() > 0){
            do {


                Locais locais = new Locais();
                locais.setId(cursor.getInt(1));
                locais.setnSala(cursor.getString(2));
                locais.setNome(cursor.getString(3));
                locais.setNumContato(cursor.getString(4));
                locais.setEmail(cursor.getString(5));
                locais.setTempVisit(cursor.getInt(6));
                locais.setDescricao(cursor.getString(7));

                maplocais.put(cursor.getInt(1), locais);

            }while(cursor.moveToNext());


        }
        return maplocais;
    }
}