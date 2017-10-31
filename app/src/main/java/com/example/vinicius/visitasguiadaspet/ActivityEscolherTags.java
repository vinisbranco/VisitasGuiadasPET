package com.example.vinicius.visitasguiadaspet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class ActivityEscolherTags extends AppCompatActivity{

    CheckBox robotica,compGrafica, virtualizacao, sisAutonomos, sisEmbarcados, intArtificial;
    Button btnVoltar,btnGerarLista;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_tags);

        btnVoltar = (Button) findViewById(R.id.btn_voltar);
        btnVoltar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });

        btnGerarLista = (Button) findViewById(R.id.btn_gerar_roteiro);
        btnGerarLista.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(ActivityEscolherTags.this, ActivityListaProjetoPersonalizada.class);

                String tags = "";

                robotica = (CheckBox) findViewById(R.id.item1);
                compGrafica = (CheckBox) findViewById(R.id.item2);
                virtualizacao = (CheckBox) findViewById(R.id.item3);
                sisAutonomos = (CheckBox) findViewById(R.id.item4);
                sisEmbarcados = (CheckBox) findViewById(R.id.item5);
                intArtificial = (CheckBox) findViewById(R.id.item6);

                if(robotica.isChecked()){
                    tags = tags + "," + robotica.getText();
                }
                if(compGrafica.isChecked()){
                    tags = tags + "," + compGrafica.getText();
                }
                if(virtualizacao.isChecked()){
                    tags = tags + "," + virtualizacao.getText();
                }
                if(sisAutonomos.isChecked()){
                    tags = tags + "," + sisAutonomos.getText();
                }
                if(sisEmbarcados.isChecked()){
                    tags = tags + "," + sisEmbarcados.getText();
                }
                if(intArtificial.isChecked()){
                    tags = tags + "," + intArtificial.getText();
                }

                intent.putExtra("tags", tags);
                startActivity(intent);
            }
        });



    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


}
