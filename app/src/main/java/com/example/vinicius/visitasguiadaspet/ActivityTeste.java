package com.example.vinicius.visitasguiadaspet;

import android.app.AlertDialog;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.vinicius.visitasguiadaspet.Dominio.BancoTeste;
import com.example.vinicius.visitasguiadaspet.Dominio.LocaisTeste;

import org.json.JSONObject;

import java.util.List;

public class ActivityTeste extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        try{
            SQLiteDatabase db = new BancoTeste(this).getDatabase();
            BancoTeste helper = new BancoTeste(this);
            helper.onUpgrade(db,1,1);

            ListView lista_teste = (ListView) findViewById(R.id.lista_teste);

            LocaisTeste source = new LocaisTeste(this);
            List<JSONObject> lista = source.allLocais();

            ArrayAdapter<JSONObject> adapter = new AdapterListaTeste(this, lista);

            lista_teste.setAdapter(adapter);
        }catch (Throwable e){
            new AlertDialog.Builder(this).setTitle("Erro").setMessage(e.toString()).show();
        }




    }
}
