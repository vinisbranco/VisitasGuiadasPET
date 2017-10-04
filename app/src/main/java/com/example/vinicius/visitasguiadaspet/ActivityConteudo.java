package com.example.vinicius.visitasguiadaspet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ActivityConteudo extends AppCompatActivity {

    TextView txtNome;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteudo);

        txtNome = (TextView) findViewById(R.id.txtNome);

        mDatabase = FirebaseDatabase.getInstance().getReference("Entidades");

        mDatabase.child("nome").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String nome = dataSnapshot.getValue(String.class);
                txtNome.setText(nome);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
