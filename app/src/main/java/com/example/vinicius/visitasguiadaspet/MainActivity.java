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

        locais = new Locais(5, "625", "GRV - Laboratório de Realidade Virtual", "5133203558", "marcio.pinho@pucrs.br", 15, "The Virtual Reality Group perform researches in the areas of virtual reality, augmented reality, image processing. We are located on the 6th floor of the building 32 PUCRS Porto Alegre Campus.");
        horarios = new Horarios(1, "Segunda", null, null, "14:00:00","17:30:00", locais);
        horarios2 = new Horarios(2, "Terça", null, null, "14:00:00","17:30:00", locais);
        horarios3 = new Horarios(3, "Quarta", null, null, "14:00:00","17:30:00", locais);
        horarios4 = new Horarios(4, "Quinta", null, null, "14:00:00","17:30:00", locais);
        horarios5 = new Horarios(5, "Sexta", null, null, "14:00:00","17:30:00", locais);

        locais = new Locais(6, "626", "LSA - Laboratório de Sistemas Autônomos", null, "mobile.robot.pucrs@gmail.com", 10, "LSA is devoted mainly to environmental, humanitarian, educational, and industrial applications for the benefit of mankind. The laboratory combines researchers from different areas (embedded systems, computer vision, AI) to design innovative solutions, bridging the existing robotics research gap between hardware and software.");
        horarios = new Horarios(1, "Segunda", null, null, "14:00:00","17:30:00", locais);
        horarios2 = new Horarios(2, "Terça", null, null, "14:00:00","17:30:00", locais);
        horarios3 = new Horarios(3, "Quarta", null, null, "14:00:00","17:30:00", locais);
        horarios4 = new Horarios(4, "Quinta", null, null, "14:00:00","17:30:00", locais);
        horarios5 = new Horarios(5, "Sexta", null, null, "14:00:00","17:30:00", locais);

        locais = new Locais(7, "627", "SMART - Grupo de Pesquisa ", null , "smart.pucrs@gmail.com", 15, "The SMART research group produces internationally leading research in Artificial Intelligence, especially in the areas of multi-agent systems and domain-specific knowledge representation using formal ontologies. Overall, the group aims to employ the techniques it develops in the production of innovative technology for the social good and sustainability.");
        horarios = new Horarios(1, "Segunda", null, null, "14:00:00","17:30:00", locais);
        horarios2 = new Horarios(2, "Terça", null, null, "14:00:00","17:30:00", locais);
        horarios3 = new Horarios(3, "Quarta", null, null, "14:00:00","17:30:00", locais);
        horarios4 = new Horarios(4, "Quinta", null, null, "14:00:00","17:30:00", locais);
        horarios5 = new Horarios(5, "Sexta", null, null, "14:00:00","17:30:00", locais);

        locais = new Locais(8, "628", "GPIN - Laboratório de Pesquisa em Inteligência de Negócio", null, "duncan@pucrs.br", 15, "o Grupo de Pesquisa em Inteligência de Negócio, GPIN, busca pesquisar temas relacionados à Inteligência de Processos de Negócio, bem como disseminar os resultados de suas pesquisas através da formação na graduação e na pós-graduação. \n Entre os principais temas de pesquisa estão: sistemas de descoberta de conhecimento, mineração de dados, data warehousing, bancos de dados ativos e temporais e automação de processos de negócio.");
        horarios = new Horarios(1, "Segunda", null, null, "14:00:00","17:30:00", locais);
        horarios2 = new Horarios(2, "Terça", null, null, "14:00:00","17:30:00", locais);
        horarios3 = new Horarios(3, "Quarta", null, null, "14:00:00","17:30:00", locais);
        horarios4 = new Horarios(4, "Quinta", null, null, "14:00:00","17:30:00", locais);
        horarios5 = new Horarios(5, "Sexta", null, null, "14:00:00","17:30:00", locais);

        locais = new Locais(9, "630", "PLN - Laboratório de Processamento de Linguagem Natural", "33203611", "renata.vieira@pucrs.br", 15, "O grupo desenvolve trabalhos que se destacam em duas linhas: formação de pessoas e produção científica. Na formação, destacamos a qualidade da formação dos egressos e a fixação dos mesmos em IES (ex.: USP, UCS), órgãos públicos (ex.: ABIN) e empresas privadas (ex.: MICROSOFT, GODIGITAL). Na vertente da geração de conhecimento, o grupo vem desenvolvendo projetos que o projetam como integrador de instituições nacionais (PUCRS, UFRGS, UFSC, UNICAMP, UFSCAR e USP). Os laços de cooperação internacional são com Portugal, Espanha, França e Uruguay. O grupo se envolve com atividades da comunidade científica da área de Processamento de Linguagem Natural, através da participação em sociedades científicas nacionais como a SBC (Sociedade Brasileira de Computação) e internacionais como a ACL (The Association for Computational Linguistics).");
        horarios = new Horarios(1, "Segunda", null, null, "14:00:00","17:30:00", locais);
        horarios2 = new Horarios(2, "Terça", null, null, "14:00:00","17:30:00", locais);
        horarios3 = new Horarios(3, "Quarta", null, null, "14:00:00","17:30:00", locais);
        horarios4 = new Horarios(4, "Quinta", null, null, "14:00:00","17:30:00", locais);
        horarios5 = new Horarios(5, "Sexta", null, null, "14:00:00","17:30:00", locais);

        locais = new Locais(10, "653", "LSHV - Laboratório de Simulação de Humanos Virtuais", "5133203611", "soraia.musse@pucrs.br", 15, "Created in 2007, VHLab develops research on Computer Graphics, Crowd Simulation, Computer Vision, Facial Animation, Virtual Human Simulation, among others.");
        horarios = new Horarios(1, "Segunda", null, null, "14:00:00","17:30:00", locais);
        horarios2 = new Horarios(2, "Terça", null, null, "14:00:00","17:30:00", locais);
        horarios3 = new Horarios(3, "Quarta", null, null, "14:00:00","17:30:00", locais);
        horarios4 = new Horarios(4, "Quinta", null, null, "14:00:00","17:30:00", locais);
        horarios5 = new Horarios(5, "Sexta", null, null, "14:00:00","17:30:00", locais);

        locais = new Locais(11, "654", "DaVint - Laboratório de Realidade Virtual", "5133203558", "marcio.pinho@pucrs.br", 15, "The Virtual Reality Group perform researches in the areas of virtual reality, augmented reality, image processing. We are located on the 6th floor of the building 32 PUCRS Porto Alegre Campus.");
        horarios = new Horarios(1, "Segunda", null, null, "14:00:00","17:30:00", locais);
        horarios2 = new Horarios(2, "Terça", null, null, "14:00:00","17:30:00", locais);
        horarios3 = new Horarios(3, "Quarta", null, null, "14:00:00","17:30:00", locais);
        horarios4 = new Horarios(4, "Quinta", null, null, "14:00:00","17:30:00", locais);
        horarios5 = new Horarios(5, "Sexta", null, null, "14:00:00","17:30:00", locais);

    }
}
