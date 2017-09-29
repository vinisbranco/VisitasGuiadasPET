package com.example.vinicius.visitasguiadaspet;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.vinicius.visitasguiadaspet.Database.Banco;
import com.example.vinicius.visitasguiadaspet.Dominio.RepositorioLocais;

public class MainActivity extends AppCompatActivity {

    private Banco banco;
    private SQLiteDatabase conn;
    private ListView lstLocais;
    private ArrayAdapter<String> adpLocais;
    private RepositorioLocais repositorioLocais;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {

            banco = new Banco(this);
            conn = banco.getWritableDatabase();

            repositorioLocais = new RepositorioLocais(conn);
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
}
