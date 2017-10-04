package com.example.vinicius.visitasguiadaspet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityConteudo extends AppCompatActivity {

    TextView txtNome;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteudo);

        txtNome = (TextView) findViewById(R.id.txtNome);

        mDatabase = FirebaseDatabase.getInstance().getReference("Entidades").child("1").child("nome");

        final String nome = mDatabase.push().getKey();

        txtNome.setText(nome);


    }
}
