package com.example.vinicius.visitasguiadaspet.Dominio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.vinicius.visitasguiadaspet.Dominio.Entidades.Horarios;
import com.example.vinicius.visitasguiadaspet.Dominio.Entidades.Locais;

/**
 * Created by vinicius on 06/10/17.
 */

public class RepositorioHorarios {
    private SQLiteDatabase conn;
    private ListView lstLocais;


    public RepositorioHorarios(SQLiteDatabase conn){
        this.conn = conn;

    }
    public void inserir(Horarios horarios){
        ContentValues values = new ContentValues();

        values.put("id", horarios.getLocais().getId());
        values.put("idHor", horarios.getIdhor());
        values.put("DiaSem", horarios.getDiaSem());
        values.put("HorentradaMan", horarios.getHorEntrManh());
        values.put("HorsaidaMan", horarios.getHorSaiManh());
        values.put("HorentradaTar", horarios.getHorEntrTar());
        values.put("HorsaidaTar", horarios.getHorSaiTar());

        conn.insertOrThrow("HORARIOS", null, values);

    }

    public ArrayAdapter<Horarios> buscaHorarios(Context context){

        ArrayAdapter<Horarios> adpHorarios = new ArrayAdapter<Horarios>(context, android.R.layout.simple_list_item_1);

        Cursor cursor = conn.query("HORARIOS", null, null, null, null, null, null);



        if(cursor.getCount() > 0){
            do {

                Horarios horarios = new Horarios();
                horarios.setIdhor(cursor.getInt(2));
                adpHorarios.add(horarios);
            }while(cursor.moveToNext());


        }
        return adpHorarios;
    }
}
