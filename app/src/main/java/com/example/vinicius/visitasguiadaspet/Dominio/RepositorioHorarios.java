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
    private RepositorioLocais replocais;


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
                ArrayAdapter<Locais> adpLocais = new ArrayAdapter<Locais>(context, android.R.layout.simple_list_item_1);
                adpLocais = replocais.buscaLocais(context);
                Locais locais = new Locais();
                for(int i=0; i <= adpLocais.getCount(); i++) {
                    if (adpLocais.getItem(i).getId() == cursor.getInt(1)) {
                        locais = adpLocais.getItem(i);
                        break;
                    }
                }

                Horarios horarios = new Horarios();
                horarios.setLocais(locais);
                horarios.setIdhor(cursor.getInt(2));
                horarios.setDiaSem(cursor.getString(3));
                horarios.setHorEntrManh(cursor.getString(4));
                horarios.setHorSaiManh(cursor.getString(5));
                horarios.setHorEntrTar(cursor.getString(6));
                horarios.setHorSaiTar(cursor.getString(7));

                adpHorarios.add(horarios);
            }while(cursor.moveToNext());


        }
        return adpHorarios;
    }
}
