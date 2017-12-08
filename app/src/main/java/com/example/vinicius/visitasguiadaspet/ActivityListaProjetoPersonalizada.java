package com.example.vinicius.visitasguiadaspet;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.vinicius.visitasguiadaspet.Dominio.BancoTeste;
import com.example.vinicius.visitasguiadaspet.Dominio.LocaisTeste;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ActivityListaProjetoPersonalizada extends AppCompatActivity {

    List<JSONObject> lista_aux = new LinkedList<JSONObject>();
    String emails = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_conteudo);

        try{
            SQLiteDatabase db = new BancoTeste(this).getDatabase();
            BancoTeste criarBd = new BancoTeste(this);
            criarBd.removerBanco(db);
            criarBd.onCreate(db);

            LocaisTeste source = new LocaisTeste(this);
            ListView listaView = (ListView) findViewById(R.id.lista);

            lista_aux = source.allLocais();
            for(int i=0; i<lista_aux.size(); i++){
                String tagsElementos = lista_aux.get(i).getString("tags");
                String[] tagsIntent = getIntent().getExtras().getString("tags").split(",");
                tagsIntent[0] = (tagsIntent[0].equals("")) ? "0":tagsIntent[0];
                boolean naoPossui = true;
                for(int j = 0; j<tagsIntent.length; j++){
                    if(tagsElementos.contains(tagsIntent[j])){
                        naoPossui = false;
                        break;
                    }
                }
                if(naoPossui){
                    lista_aux.remove(i);
                    i--;
                }else{
                    emails = lista_aux.get(i).getString("email") + "," + emails;
                }

            }

            ArrayAdapter<JSONObject> adapter = new AdapterListaTeste(this, lista_aux);

            listaView.setAdapter(adapter);

        }catch(Throwable e){
            new AlertDialog.Builder(this).setTitle("Erro").setMessage(e.toString()).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lista, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.btn_menu_confirmar:
                //Gerar a Mensagem automática com base nas informações adquiridas até aqui;
                Intent it = new Intent(Intent.ACTION_SEND);
                String[] to = emails.split(",");
                it.putExtra(Intent.EXTRA_EMAIL, to);
                it.putExtra(Intent.EXTRA_SUBJECT, "Nova visita agendada");
                //Primeira mensagem
                String msg = "Visita agendada:";
                //Tags
                String[] aux = getIntent().getExtras().get("tags").toString().split(",");
                String tags = "";
                for (int i=0; i<aux.length; i++){
                    if(i==1){
                        tags = aux[i];
                    }else{
                        tags = tags + ", "+aux[i];
                    }
                }
                tags = tags + ".";
                //FIM
                //Soma do tempo de cada visita
                String[] horario = getIntent().getExtras().getString("horario").split(":");
                int hora = Integer.parseInt(horario[0]);
                int min = Integer.parseInt(horario[1]);


                String projeto = "";
                try {
                    for (int i = 0; i < lista_aux.size(); i++) {

                        String nome = lista_aux.get(i).getString("nome");
                        String sala = lista_aux.get(i).getString("sala");
                        projeto = projeto + "\n" + (i + 1) + "ª Local: " + nome
                                + "\nSala: " + sala + "\n"
                                + "Horário: " + hora + ":" + min;
                        min = min + 20;
                        if (min >= 60) {
                            hora++;
                            min = min - 60;
                        }
                        if (min < 10 && hora < 10) {
                            projeto = projeto + " - 0" + hora + ":0" + min + "\n";
                        } else if (hora < 10) {
                            projeto = projeto + " - 0" + hora + ":" + min + "\n";
                        } else if (min < 10) {
                            projeto = projeto + " - " + hora + ":0" + min + "\n";
                        } else {
                            projeto = projeto + " - " + hora + ":" + min + "\n";
                        }
                    }
                }catch(Throwable e){
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                //FIM

                msg = msg +"\n\n->Informações:\n\n"
                        + "-Visitante:\n"
                        + getIntent().getExtras().get("info_usuario")
                        +"\nInteresses: "+tags+"\n\n"
                        + projeto;

                it.putExtra(Intent.EXTRA_TEXT, msg);
                it.setData(Uri.parse("mailto:"));
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
