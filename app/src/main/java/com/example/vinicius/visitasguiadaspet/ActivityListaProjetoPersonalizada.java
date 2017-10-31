package com.example.vinicius.visitasguiadaspet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityListaProjetoPersonalizada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_conteudo);

        ListView lista = (ListView) findViewById(R.id.lista);
        ArrayList<Projeto> projetos = listaDeProjetos();
        ArrayAdapter adapter = new ListaAdapter(this, listaDeProjetos());
        lista.setAdapter(adapter);




    }

    private ArrayList<Projeto> listaDeProjetos(){
        ArrayList<Projeto> projetos = new ArrayList<Projeto>();
        Projeto projeto = new Projeto("PET","701","40028922","petinf@pucrs.br","14:00-17:30","Os estudantes são responsáveis pela organização de atividades de integração destinadas ao público interno da universidade: estudantes, professores e outros servidores."
                ,R.mipmap.ic_pet);
        projetos.add(projeto);
        projeto = new Projeto("AGES","107","99998888","ages@pucrs.br","14:00-17:30","O objetivo do Curso de Bacharelado em Engenharia de Software é formar profissionais com sólida competência e conhecimento profundo de arquitetura de software, tecnologias e processos de desenvolvimento, de maneira a poder produzir software robusto e com qualidade, de maneira sistemática e eficiente, desde aplicativos simples até sistemas críticos de alta complexidade."
                ,R.mipmap.ic_ages);
        projetos.add(projeto);
        projeto = new Projeto("CePES","106","77776666","cepes@pucrs.br","08:00-17:30","O Centro de Estudos Políticos e Sociais, fundado em outubro de 1992, constitui-se em uma associação de pessoas preocupadas em analisar as instituições e os vários aspectos da sociedade, na procura de soluções balizadas pelo liberalismo político."
                ,R.mipmap.ic_cepes);
        projetos.add(projeto);

        return projetos;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lista, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.btn_menu_confirmar:
                Toast.makeText(this, "Lista confirmada com sucesso!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_deletar:
                finish();
                Toast.makeText(this, "Lista concelada com sucesso!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

}
