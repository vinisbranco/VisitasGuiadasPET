package com.example.vinicius.visitasguiadaspet.Dominio;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.vinicius.visitasguiadaspet.R;

/**
 * Created by vinicius on 08/11/17.
 */

public class Listar extends Activity {

    SQLiteDatabase db;
    Cursor cursor;
    SimpleCursorAdapter ad;
    ListView listView;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        buscarDados();

        criarListagem();
    }

    public void buscarDados(){
        try{
            db = openOrCreateDatabase("LOCAIS.db", Context.MODE_PRIVATE,null);
            cursor = db.rawQuery("SELECT * from contatos", null);
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"ERROR", Toast.LENGTH_SHORT).show();

        }
    }
    public void criarListagem(){
        listView = (ListView) findViewById(R.id.List);

        String[] from = {"id", "nSala", "nome"};
        int[] to = {R.id.txvContaNome,R.id.txvContaEmail, R.id.txvContaFone};

        ad = new SimpleCursorAdapter(getApplicationContext(), R.layout.model_list_view,cursor,from,to);

        //listView.setOnClickListener(this);
        listView.setAdapter(ad);
    }
}
