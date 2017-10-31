package com.example.vinicius.visitasguiadaspet;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityConteudo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteudo);

        ImageView image = (ImageView) findViewById(R.id.imagem_conteudo);
        image.setImageResource(getIntent().getIntExtra("image",R.mipmap.ic_icon_default));

        TextView txt1 = (TextView) findViewById(R.id.txt1);
        txt1.setText(getIntent().getStringExtra("nome"));

        TextView txt2 = (TextView) findViewById(R.id.txt2);
        txt2.setText("Sala: "+getIntent().getStringExtra("sala"));

        TextView txt3 = (TextView) findViewById(R.id.txt3);
        txt3.setText("Contato: "+getIntent().getStringExtra("numContato"));

        TextView txt4 = (TextView) findViewById(R.id.txt4);
        txt4.setText("E-mail: "+getIntent().getStringExtra("email"));

        TextView txt5 = (TextView) findViewById(R.id.txt5);
        txt5.setText("Horário: "+getIntent().getStringExtra("tempVisita"));

        TextView txt6 = (TextView) findViewById(R.id.txt6);
        txt6.setText("Descrição: "+getIntent().getStringExtra("descricao"));

    }
}
