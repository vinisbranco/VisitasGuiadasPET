package com.example.vinicius.visitasguiadaspet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.vinicius.visitasguiadaspet.Dominio.BancoTeste;
import com.example.vinicius.visitasguiadaspet.Dominio.LocaisTeste;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ActivityListaProjetoCompleta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        ListView lista = (ListView) findViewById(R.id.List);

        LocaisTeste locais = new LocaisTeste(this);

        List<JSONObject> lista_locais = locais.allLocais();
        lista_locais.remove(0);

        ArrayAdapter adapter = new AdapterListaTeste(this, lista_locais);

        lista.setAdapter(adapter);

    }

}
