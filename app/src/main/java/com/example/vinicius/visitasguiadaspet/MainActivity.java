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
import com.example.vinicius.visitasguiadaspet.Database.Banco3;
import com.example.vinicius.visitasguiadaspet.Dominio.Entidades.Horarios;
import com.example.vinicius.visitasguiadaspet.Dominio.Entidades.Locais;
import com.example.vinicius.visitasguiadaspet.Dominio.Entidades.Tags;
import com.example.vinicius.visitasguiadaspet.Dominio.RepositorioHorarios;
import com.example.vinicius.visitasguiadaspet.Dominio.RepositorioLocais;
import com.example.vinicius.visitasguiadaspet.Dominio.RepositorioTags;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Banco banco;
    private Banco2 banco2;
    private Banco3 banco3;
    private SQLiteDatabase conn;
    private SQLiteDatabase conn2;
    private SQLiteDatabase conn3;
    private ListView lstLocais;
    private ArrayAdapter<String> adpLocais;
    private ArrayAdapter<String> adpHorarios;
    private ArrayAdapter<String> adpTags;
    private RepositorioLocais repositorioLocais;
    private RepositorioHorarios repositorioHorarios;
    private RepositorioTags repositorioTags;
    private Locais locais;
    private Horarios horarios;
    private Horarios horarios2;
    private Horarios horarios3;
    private Horarios horarios4;
    private Horarios horarios5;
    private Tags tags;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);


        try {

            banco = new Banco(this);
            banco2 = new Banco2(this);
            banco3 = new Banco3(this);
            conn = banco.getWritableDatabase();
            conn2 = banco2.getWritableDatabase();
            conn3 = banco3.getWritableDatabase();

            repositorioLocais = new RepositorioLocais(conn);
            repositorioHorarios = new RepositorioHorarios(conn2);
            repositorioTags = new RepositorioTags(conn3);
            adpLocais = repositorioLocais.buscaLocais(this);
            adpHorarios = repositorioHorarios.buscaHorarios(this);
            adpTags = repositorioTags.buscaTags(this);

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

    private  void inserir(){
        Locais(int id, String nSala, String nome, int numContato , String email, int tempVisit, String descricao)
        Horarios(int idhor, String DiaSem, String HorEntrManh, String HorSaiManh, String HorEntrTar, String HorSaiTar, Locais locais)

        locais = new Locais(1, "701", "PET Informática", null, "petinf.pucrs@gmail.com", 15, "O PET (Programa de Educação Tutorial) é um programa realizado pelo MEC que consiste em três pilares principais: ensino, extensão e pesquisa & desenvolvimento. O grupo é formado por 12 bolsistas que atuam nas três áreas, realizando tarefas como organização de palestras, desenvolvimento de artigos e minicursos e auxiliam em projetos de extensão.");
        horarios = new Horarios(1, "Segunda", null, null, "14:00:00","17:30:00", locais);
        horarios2 = new Horarios(2, "Terça", null, null, "14:00:00","17:30:00", locais);
        horarios3 = new Horarios(3, "Quarta", null, null, "14:00:00","17:30:00", locais);
        horarios4 = new Horarios(4, "Quinta", null, null, "14:00:00","17:30:00", locais);
        horarios5 = new Horarios(5, "Sexta", null, null, "14:00:00","17:30:00", locais);
        tags = new Tags(1, "Pesquisa",locais);

        locais = new Locais(2, "107", "AGES - Agência Expperimental de Engenharia de Software", "5133536059", "ages@pucrs.br", 20, "A AGES é componente curricular do Curso de Bacharelado em Engenharia de Software, integrada com as outras disciplinas do curso. O estudante passa pela dinâmica da Agência por 4 vezes durante seu curso. Estas passagens se dão em níveis diferentes de maturidade, propondo novos desafios e ajudando os estudantes a construírem progressivamente suas habilidades. Entre os objetivos do perfil do egresso deste curso, a autonomia deve especialmente ser trabalhada com os elementos da Agência. O domínio dos métodos e processos, para além das tecnologias e das técnicas, pressupõe a vivência de situações reais onde a aplicação desses conhecimentos é contextuada pelo cotidiano.");
        horarios = new Horarios(1, "Segunda", null, null, "13:30:00","22:45:00", locais);
        horarios2 = new Horarios(2, "Terça", null, null, "13:30:00","22:45:00", locais);
        horarios3 = new Horarios(3, "Quarta", null, null, "13:30:00","22:45:00", locais);
        horarios4 = new Horarios(4, "Quinta", null, null, "13:30:00","22:45:00", locais);
        horarios5 = new Horarios(5, "Sexta", null, null, "13:30:00","22:45:00", locais);

        locais = new Locais(3, "601", "GMAP - Laboratório de Modelagem de Aplicações Paralelas", "5133536059", "ages@pucrs.br", 20, "A AGES é componente curricular do Curso de Bacharelado em Engenharia de Software, integrada com as outras disciplinas do curso. O estudante passa pela dinâmica da Agência por 4 vezes durante seu curso. Estas passagens se dão em níveis diferentes de maturidade, propondo novos desafios e ajudando os estudantes a construírem progressivamente suas habilidades. Entre os objetivos do perfil do egresso deste curso, a autonomia deve especialmente ser trabalhada com os elementos da Agência. O domínio dos métodos e processos, para além das tecnologias e das técnicas, pressupõe a vivência de situações reais onde a aplicação desses conhecimentos é contextuada pelo cotidiano.");
        horarios = new Horarios(1, "Segunda", null, null, "14:00:00","17:30:00", locais);
        horarios2 = new Horarios(2, "Terça", null, null, "14:00:00","17:30:00", locais);
        horarios3 = new Horarios(3, "Quarta", null, null, "14:00:00","17:30:00", locais);
        horarios4 = new Horarios(4, "Quinta", null, null, "14:00:00","17:30:00", locais);
        horarios5 = new Horarios(5, "Sexta", null, null, "14:00:00","17:30:00", locais);

        locais = new Locais(4, "602", "LABIO - Laboratório de Bioinformática, modelagem e simulação de Biossitemas", null, "osmar.norberto@pucrs.br", 15, "O Laboratório de Bioinformática, Modelagem e Simulação de Biossistemas (LaBio), criado em 2002, é liderado pelo professor Osmar Norberto de Souza. A estrutura, que abriga o Grupo de Biofísica Molecular Computacional, Modelagem e Simulação de Biossistemas, promove investigações interdisciplinares que permeiam as principais áreas de pesquisas biomédicas realizadas na PUCRS e por parceiros da Instituição, dentro e fora do Brasil. As atividades são conduzidas a partir de quatro linhas de pesquisa: Bioinformática e Computação Bioinspirada; Biologia Molecular da Interação Droga/Alvo; Genética, Genômica e Bioinformática; Pesquisa e Avaliação de Alvos Moleculares.");
        horarios = new Horarios(1, "Segunda", null, null, "14:00:00","17:30:00", locais);
        horarios2 = new Horarios(2, "Terça", null, null, "14:00:00","17:30:00", locais);
        horarios3 = new Horarios(3, "Quarta", null, null, "14:00:00","17:30:00", locais);
        horarios4 = new Horarios(4, "Quinta", null, null, "14:00:00","17:30:00", locais);
        horarios5 = new Horarios(5, "Sexta", null, null, "14:00:00","17:30:00", locais);

        locais = new Locais(4, "602", "LABIO - Laboratório de Bioinformática, modelagem e simulação de Biossitemas", null, "osmar.norberto@pucrs.br", 15, "O Laboratório de Bioinformática, Modelagem e Simulação de Biossistemas (LaBio), criado em 2002, é liderado pelo professor Osmar Norberto de Souza. A estrutura, que abriga o Grupo de Biofísica Molecular Computacional, Modelagem e Simulação de Biossistemas, promove investigações interdisciplinares que permeiam as principais áreas de pesquisas biomédicas realizadas na PUCRS e por parceiros da Instituição, dentro e fora do Brasil. As atividades são conduzidas a partir de quatro linhas de pesquisa: Bioinformática e Computação Bioinspirada; Biologia Molecular da Interação Droga/Alvo; Genética, Genômica e Bioinformática; Pesquisa e Avaliação de Alvos Moleculares.");
        horarios = new Horarios(1, "Segunda", null, null, "14:00:00","17:30:00", locais);
        horarios2 = new Horarios(2, "Terça", null, null, "14:00:00","17:30:00", locais);
        horarios3 = new Horarios(3, "Quarta", null, null, "14:00:00","17:30:00", locais);
        horarios4 = new Horarios(4, "Quinta", null, null, "14:00:00","17:30:00", locais);
        horarios5 = new Horarios(5, "Sexta", null, null, "14:00:00","17:30:00", locais);



    }
}
