package com.example.vinicius.visitasguiadaspet;

import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vinicius.visitasguiadaspet.Database.Banco;
import com.example.vinicius.visitasguiadaspet.Dominio.Entidades.Locais;
import com.example.vinicius.visitasguiadaspet.Dominio.RepositorioLocais;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class ActivityListaProjetoPersonalizada extends AppCompatActivity {

    final ArrayList<Projeto> projetos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_conteudo);
        /*
            Banco bd = new Banco(this);
            SQLiteDatabase conn = bd.getWritableDatabase();
            RepositorioLocais repositorioLocais = new RepositorioLocais(conn);

            TextView tv = (TextView) findViewById(R.id.teste);
            HashMap<Integer, Locais> listaHash = repositorioLocais.buscaLocais();
            Collection<Locais> locais = listaHash.values();
            String locais2 = locais.toString();
            tv.setText(locais2);
        */
        ListView lista = (ListView) findViewById(R.id.lista);
        ArrayList<Projeto> aux = listaDeProjetos();
        for(int i=0; i<aux.size(); i++){
            String[] tagsElementos = aux.get(i).getTags().split(",");
            String tagsIntent = getIntent().getStringExtra("tags");
            for(int j=0; j<tagsElementos.length; j++){
                if(tagsIntent.contains(tagsElementos[j])){
                    projetos.add(aux.get(i));
                    break;
                }
            }
        }
        for(int j=0; j<projetos.size(); j++){
            int len = Integer.valueOf(projetos.get(j).getSala());
            for(int k=0; k<projetos.size(); k++){
                int len2 = Integer.valueOf(projetos.get(k).getSala());
                if(len2>len){
                    Projeto aux2 = projetos.get(j);
                    projetos.set(j, projetos.get(k));
                    projetos.set(k, aux2);
                }
            }
        }
        ArrayAdapter adapter = new ListaAdapter(this, projetos);
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
                ,R.mipmap.ic_icon_default, "Robótica,Sistemas Autônomos");
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
        projeto = new Projeto("GSE","721","11110000","gse@pucrs.br","08:00-17:30","Criado em 2003 e coordenado pelo Prof. Duncan Ruiz desde 10/2006, o Grupo de Pesquisa em Inteligência de Negócio, GPIN, busca pesquisar temas relacionados à Inteligência de Processos de Negócio, bem como disseminar os resultados de suas pesquisas através da formação na graduação e na pós-graduação.Entre os principais temas de pesquisa estão: sistemas de descoberta de conhecimento, mineração de dados, data warehousing, bancos de dados ativos e temporais e automação de processos de negócio.De modo interdisciplinar, o GPIN tem realizado parcerias com outros grupos e unidades de pesquisa vinculadas a PUCRS, entre estas, LABIO (Laboratório de Bioinformática, Modelagem e Simulação de Biossistemas), PLN (Processamento de Linguagem Natural), PEG (Performance Evaluation Group), PPGO (Programa de Pós-Graduação em Odontologia) e FAMECOS (Faculdade de Comunicação Social)."
                ,R.mipmap.ic_icon_default, "Sistemas Embarcados");
        projetos.add(projeto);
        projeto = new Projeto("GAPH","726","11110000","gaph@pucrs.br","08:00-17:30","Criado em 2003 e coordenado pelo Prof. Duncan Ruiz desde 10/2006, o Grupo de Pesquisa em Inteligência de Negócio, GPIN, busca pesquisar temas relacionados à Inteligência de Processos de Negócio, bem como disseminar os resultados de suas pesquisas através da formação na graduação e na pós-graduação.Entre os principais temas de pesquisa estão: sistemas de descoberta de conhecimento, mineração de dados, data warehousing, bancos de dados ativos e temporais e automação de processos de negócio.De modo interdisciplinar, o GPIN tem realizado parcerias com outros grupos e unidades de pesquisa vinculadas a PUCRS, entre estas, LABIO (Laboratório de Bioinformática, Modelagem e Simulação de Biossistemas), PLN (Processamento de Linguagem Natural), PEG (Performance Evaluation Group), PPGO (Programa de Pós-Graduação em Odontologia) e FAMECOS (Faculdade de Comunicação Social)."
                ,R.mipmap.ic_icon_default, "Sistemas Embarcados");
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
                //Gerar a Mensagem automática com base nas informações adquiridas até aqui;
                Intent it = new Intent(Intent.ACTION_SEND);
                it.setData(Uri.parse("mailto:"));
                String[] to = {"vinicius_ct@outlook.com.br"};
                it.putExtra(Intent.EXTRA_EMAIL, to);
                it.putExtra(Intent.EXTRA_SUBJECT, "Nova visita agendada");

                String[] aux = getIntent().getExtras().toString().split(",");
                String tags = "";
                for (int i=1; i<aux.length-1; i++){
                    if(i==1){
                        tags = aux[i];
                    }else{
                        tags = tags + ", "+aux[i];
                    }
                }
                tags = tags + ".";

                //Data e hora;
                Date data = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat();
                Calendar cal = Calendar.getInstance();
                cal.setTime(data);
                Date data_atual = cal.getTime();
                String data_completa = dateFormat.format(data_atual);
                int hora = 14;
                int min = 10;


                String projeto = "";
                for(int i=0; i<projetos.size(); i++){

                    String nome = projetos.get(i).getNome();
                    String sala = projetos.get(i).getSala();
                    projeto = projeto + "\n"+(i+1)+"ª Projeto: "+nome
                            + "\nSala: "+sala+"\n"
                            + "Horário: "+hora+":"+min;
                    min = min + 15;
                    if(min>=60){
                        hora++;
                        min = min - 60;
                    }
                    projeto = projeto + " - "+hora+":"+min+"\n";
                }


                String msg ="->Informações:\n"
                        + "-Visitante:\n\n"
                        + "Nome: "+"Vinicius C. Teixeira\n"
                        + "Idade: "+"18\n"
                        + "Empresa: "+"TECNOPUCRS\n"
                        + "Interese: "+tags
                        + "\n\n-Visita: \n\n"
                        + "Data: "+data_completa.substring(0,data_completa.indexOf(" "))+"\n"
                        + projeto;


                it.putExtra(Intent.EXTRA_TEXT, msg);
                it.setType("message/rfc822");
                startActivity(it);
                break;
            case R.id.btn_deletar:
                finish();
                Toast.makeText(this, "Lista cancelada com sucesso!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }



}
