package com.example.vinicius.visitasguiadaspet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TableRow;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ActivityInfoUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_usuario);

        final TableRow escola = (TableRow) findViewById(R.id.row_escola);
        final TableRow aluno = (TableRow) findViewById(R.id.row_aluno);

        RadioButton individual = (RadioButton) findViewById(R.id.individual);
        individual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aluno.setVisibility(View.INVISIBLE);
                escola.setVisibility(View.INVISIBLE);
            }
        });
        RadioButton grupo = (RadioButton) findViewById(R.id.grupo);
        grupo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aluno.setVisibility(View.VISIBLE);
                escola.setVisibility(View.VISIBLE);
            }
        });

        Button btn_confirmar = (Button) findViewById(R.id.btn_confirmar_info);
        Button btn_voltar = (Button) findViewById(R.id.btn_back);
        final EditText edt_nome = (EditText) findViewById(R.id.edt_nome);
        final EditText edt_data = (EditText) findViewById(R.id.edt_data);
        final EditText edt_horario = (EditText) findViewById(R.id.edt_horario);
        final EditText edt_cargo = (EditText) findViewById(R.id.edt_cargo);
        final EditText edt_escola = (EditText) findViewById(R.id.edt_escola);
        final EditText edt_qnt_alunos = (EditText) findViewById(R.id.edt_qnt_aluno);

        edt_nome.setText("Vinicius C. Teixeira");
        edt_data.setText(getData(false));
        edt_horario.setText(getData(true));
        edt_cargo.setText("Estudante");


        btn_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(ActivityInfoUsuario.this, ActivityEscolherTags.class);
                String horario = edt_horario.getText().toString();
                String info = "Nome: "+edt_nome.getText()
                                +"\nData: "+edt_data.getText()
                                +"\nHorário: "+ horario
                                +"\nCargo: "+edt_cargo.getText();
                if(!edt_escola.getText().toString().equals("")){
                    info = info +"\nEscola: "+edt_escola.getText().toString();
                }
                if(!edt_qnt_alunos.getText().toString().equals("")){
                    info = info + "\nQª. alunos: "+edt_qnt_alunos.getText();
                }
                it.putExtra("info_usuario", info);
                it.putExtra("horario", horario);

                startActivity(it);
            }
        });

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public String getData(boolean hora){
        Date data = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        Date data_atual = cal.getTime();
        String[] data_hora = dateFormat.format(data_atual).split(" ");
        if(hora) return data_hora[1];
        else return data_hora[0];
    }



}
