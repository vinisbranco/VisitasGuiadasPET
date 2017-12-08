package com.example.vinicius.visitasguiadaspet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class ActivityEscolherTags extends AppCompatActivity{

    CheckBox robotica,procDados,hardware,iot,saude,compGrafica, virtualizacao, outros, engDeSoft, intArtificial;
    Button btnVoltar,btnGerarLista;

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
                iot = (CheckBox) findViewById(R.id.item2);
                compGrafica = (CheckBox) findViewById(R.id.item3);
                intArtificial = (CheckBox) findViewById(R.id.item4);
                engDeSoft = (CheckBox) findViewById(R.id.item5);
                virtualizacao = (CheckBox) findViewById(R.id.item6);
                hardware = (CheckBox) findViewById(R.id.item7);
                procDados = (CheckBox) findViewById(R.id.item8);
                saude = (CheckBox) findViewById(R.id.item9);
                outros = (CheckBox) findViewById(R.id.item10);

                if(robotica.isChecked()){
                    tags = tags + "," + robotica.getText();
                }
                if(compGrafica.isChecked()){
                    tags = tags + "," + compGrafica.getText();
                }
                if(virtualizacao.isChecked()){
                    tags = tags + "," + virtualizacao.getText();
                }
                if(engDeSoft.isChecked()){
                    tags = tags + "," + engDeSoft.getText();
                }
                if(intArtificial.isChecked()){
                    tags = tags + "," + intArtificial.getText();
                }
                if(outros.isChecked()){
                    tags = tags + "," + outros.getText();
                }
                if(procDados.isChecked()){
                    tags = tags + "," + procDados.getText();
                }
                if(iot.isChecked()){
                    tags = tags + "," + iot.getText();
                }
                if(saude.isChecked()){
                    tags = tags + "," + saude.getText();
                }
                if(hardware.isChecked()){
                    tags = tags + "," + hardware.getText();
                }

                intent.putExtra("tags", tags);
                intent.putExtra("info_usuario",getIntent().getExtras().getString("info_usuario"));
                intent.putExtra("horario", getIntent().getExtras().getString("horario"));
                startActivity(intent);
            }
        });



    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


}
