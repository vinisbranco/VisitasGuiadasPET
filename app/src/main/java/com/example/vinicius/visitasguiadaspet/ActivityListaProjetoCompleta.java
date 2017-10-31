package com.example.vinicius.visitasguiadaspet;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityListaProjetoCompleta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_projeto_completa);

        ListView lista = (ListView) findViewById(R.id.lista_completa);
        ArrayList<Projeto> projetos = listaDeProjetos();
        ArrayAdapter adapter = new ListaCompletaAdapter(this, listaDeProjetos());
        lista.setAdapter(adapter);




    }

    private ArrayList<Projeto> listaDeProjetos(){
        ArrayList<Projeto> projetos = new ArrayList<Projeto>();
        Projeto projeto = new Projeto("PET","701","40028922","petinf@pucrs.br","14:00-17:30","Os estudantes são responsáveis pela organização de atividades de integração destinadas ao público interno da universidade: estudantes, professores e outros servidores."
                ,R.mipmap.ic_pet, "Robótica,Virtualização");
        projetos.add(projeto);
        projeto = new Projeto("AGES","107","99998888","ages@pucrs.br","14:00-17:30","O objetivo do Curso de Bacharelado em Engenharia de Software é formar profissionais com sólida competência e conhecimento profundo de arquitetura de software, tecnologias e processos de desenvolvimento, de maneira a poder produzir software robusto e com qualidade, de maneira sistemática e eficiente, desde aplicativos simples até sistemas críticos de alta complexidade."
                ,R.mipmap.ic_ages, "Computação Gráfica");
        projetos.add(projeto);
        projeto = new Projeto("CePES","106","77776666","cepes@pucrs.br","08:00-17:30","O Centro de Estudos Políticos e Sociais, fundado em outubro de 1992, constitui-se em uma associação de pessoas preocupadas em analisar as instituições e os vários aspectos da sociedade, na procura de soluções balizadas pelo liberalismo político."
                ,R.mipmap.ic_cepes, "Virtualização");
        projetos.add(projeto);
        projeto = new Projeto("SMART","627","55554444","smart@pucrs.br","10:00-17:00","O grupo SMART produz pesquisa reconhecida internacionalmente na área de Inteligência Artificial, principalmente por sua atuação nas áreas de sistemas multiagentes e de ontologias para representação de conhecimento específico de domínios."
                ,R.mipmap.ic_smart, "Sistemas Autônomos");
        projetos.add(projeto);
        projeto = new Projeto("DaVint","654","33332222","davint@pucrs.br","08:00-18:00","In 2011 professors Milene S. Silveira and Isabel H. Manssour began the first project of Social Networks data visualization. Professor Roberto Tietzmann joined the research team at the end of 2013. Initially the project was named as DaVis (Data Visualization) and over the years several undergraduate, masters and PhD students from both FAMECOS (School of Communications) and the FACIN (School of Computer Science), participated in the project. In 2017, with the increase of the team, and with the equipment acquired over the years, the DaVInt lab (Data Visualization and Interaction) was created. It is physically located in Room 654 of Building 32 of PUCRS. We now have 6 desktop computers, 1 notebook and 1 server, as well as tablets and cameras, and a multidisciplinary team formed by communication, administration, engineering and information technology students."
                ,R.mipmap.ic_puc_logo, "Inteligência Artificial");
        projetos.add(projeto);
        projeto = new Projeto("GPIN","725","11110000","gpin@pucrs.br","08:00-17:30","Criado em 2003 e coordenado pelo Prof. Duncan Ruiz desde 10/2006, o Grupo de Pesquisa em Inteligência de Negócio, GPIN, busca pesquisar temas relacionados à Inteligência de Processos de Negócio, bem como disseminar os resultados de suas pesquisas através da formação na graduação e na pós-graduação.Entre os principais temas de pesquisa estão: sistemas de descoberta de conhecimento, mineração de dados, data warehousing, bancos de dados ativos e temporais e automação de processos de negócio.De modo interdisciplinar, o GPIN tem realizado parcerias com outros grupos e unidades de pesquisa vinculadas a PUCRS, entre estas, LABIO (Laboratório de Bioinformática, Modelagem e Simulação de Biossistemas), PLN (Processamento de Linguagem Natural), PEG (Performance Evaluation Group), PPGO (Programa de Pós-Graduação em Odontologia) e FAMECOS (Faculdade de Comunicação Social)."
                ,R.mipmap.ic_gpin, "Sistemas Embarcados");
        projetos.add(projeto);
        projeto = new Projeto("LABIO","602","40028922","labio@pucrs.br","14:00-17:30","Os estudantes são responsáveis pela organização de atividades de integração destinadas ao público interno da universidade: estudantes, professores e outros servidores."
                ,R.mipmap.ic_icon_default, "Robótica,Virtualização");
        projetos.add(projeto);
        projeto = new Projeto("GRV","625","99998888","grv@pucrs.br","14:00-17:30","O objetivo do Curso de Bacharelado em Engenharia de Software é formar profissionais com sólida competência e conhecimento profundo de arquitetura de software, tecnologias e processos de desenvolvimento, de maneira a poder produzir software robusto e com qualidade, de maneira sistemática e eficiente, desde aplicativos simples até sistemas críticos de alta complexidade."
                ,R.mipmap.ic_icon_default, "Computação Gráfica");
        projetos.add(projeto);
        projeto = new Projeto("INCER","629","77776666","incer@pucrs.br","08:00-17:30","O Centro de Estudos Políticos e Sociais, fundado em outubro de 1992, constitui-se em uma associação de pessoas preocupadas em analisar as instituições e os vários aspectos da sociedade, na procura de soluções balizadas pelo liberalismo político."
                ,R.mipmap.ic_icon_default, "Virtualização");
        projetos.add(projeto);
        projeto = new Projeto("PLN","630","55554444","pln@pucrs.br","10:00-17:00","O grupo SMART produz pesquisa reconhecida internacionalmente na área de Inteligência Artificial, principalmente por sua atuação nas áreas de sistemas multiagentes e de ontologias para representação de conhecimento específico de domínios."
                ,R.mipmap.ic_icon_default, "Sistemas Autônomos");
        projetos.add(projeto);
        projeto = new Projeto("LSHV","653","33332222","lshv@pucrs.br","08:00-18:00","In 2011 professors Milene S. Silveira and Isabel H. Manssour began the first project of Social Networks data visualization. Professor Roberto Tietzmann joined the research team at the end of 2013. Initially the project was named as DaVis (Data Visualization) and over the years several undergraduate, masters and PhD students from both FAMECOS (School of Communications) and the FACIN (School of Computer Science), participated in the project. In 2017, with the increase of the team, and with the equipment acquired over the years, the DaVInt lab (Data Visualization and Interaction) was created. It is physically located in Room 654 of Building 32 of PUCRS. We now have 6 desktop computers, 1 notebook and 1 server, as well as tablets and cameras, and a multidisciplinary team formed by communication, administration, engineering and information technology students."
                ,R.mipmap.ic_icon_default, "Inteligência Artificial");
        projetos.add(projeto);
        projeto = new Projeto("GSE","725","11110000","gse@pucrs.br","08:00-17:30","Criado em 2003 e coordenado pelo Prof. Duncan Ruiz desde 10/2006, o Grupo de Pesquisa em Inteligência de Negócio, GPIN, busca pesquisar temas relacionados à Inteligência de Processos de Negócio, bem como disseminar os resultados de suas pesquisas através da formação na graduação e na pós-graduação.Entre os principais temas de pesquisa estão: sistemas de descoberta de conhecimento, mineração de dados, data warehousing, bancos de dados ativos e temporais e automação de processos de negócio.De modo interdisciplinar, o GPIN tem realizado parcerias com outros grupos e unidades de pesquisa vinculadas a PUCRS, entre estas, LABIO (Laboratório de Bioinformática, Modelagem e Simulação de Biossistemas), PLN (Processamento de Linguagem Natural), PEG (Performance Evaluation Group), PPGO (Programa de Pós-Graduação em Odontologia) e FAMECOS (Faculdade de Comunicação Social)."
                ,R.mipmap.ic_icon_default, "Sistemas Embarcados");
        projetos.add(projeto);
        projeto = new Projeto("GAPH","726","11110000","gaph@pucrs.br","08:00-17:30","Criado em 2003 e coordenado pelo Prof. Duncan Ruiz desde 10/2006, o Grupo de Pesquisa em Inteligência de Negócio, GPIN, busca pesquisar temas relacionados à Inteligência de Processos de Negócio, bem como disseminar os resultados de suas pesquisas através da formação na graduação e na pós-graduação.Entre os principais temas de pesquisa estão: sistemas de descoberta de conhecimento, mineração de dados, data warehousing, bancos de dados ativos e temporais e automação de processos de negócio.De modo interdisciplinar, o GPIN tem realizado parcerias com outros grupos e unidades de pesquisa vinculadas a PUCRS, entre estas, LABIO (Laboratório de Bioinformática, Modelagem e Simulação de Biossistemas), PLN (Processamento de Linguagem Natural), PEG (Performance Evaluation Group), PPGO (Programa de Pós-Graduação em Odontologia) e FAMECOS (Faculdade de Comunicação Social)."
                ,R.mipmap.ic_icon_default, "Sistemas Embarcados");
        projetos.add(projeto);

        return projetos;
    }
}
