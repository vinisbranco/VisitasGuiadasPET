package com.example.vinicius.visitasguiadaspet;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.vinicius.visitasguiadaspet.Database.Banco;
import com.example.vinicius.visitasguiadaspet.Database.Banco2;
import com.example.vinicius.visitasguiadaspet.Dominio.RepositorioHorarios;
import com.example.vinicius.visitasguiadaspet.Dominio.RepositorioLocais;

public class MainActivity extends AppCompatActivity {

    private Banco banco;
    private Banco2 banco2;
    private SQLiteDatabase conn;
    private SQLiteDatabase conn2;
    private ListView lstLocais;
    private ArrayAdapter<String> adpLocais;
    private RepositorioLocais repositorioLocais;
    private RepositorioHorarios repositorioHorarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);


        try {

            banco = new Banco(this);
            banco2 = new Banco2(this);
            conn = banco.getWritableDatabase();
            conn2 = banco2.getWritableDatabase();

            repositorioLocais = new RepositorioLocais(conn);
            repositorioHorarios = new RepositorioHorarios(conn2);
            adpLocais = repositorioLocais.buscaLocais(this);

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Conexão criada com sucesso! ");
            dlg.setNeutralButton("OK", null);
            dlg.show();



        }catch(SQLException ex){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao criar o Banco " + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();

        }

    }
    public void getConteudo(View v){
        Intent intent = new Intent(MainActivity.this, ActivityConteudo.class);
        startActivity(intent);
    }
}
