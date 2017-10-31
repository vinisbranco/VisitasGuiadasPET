package com.example.vinicius.visitasguiadaspet;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Vinicius on 16/10/2017.
 */

public class ListaAdapter extends ArrayAdapter<Projeto> {
    private Context contexto;
    private ArrayList<Projeto> elementos;

    public ListaAdapter(Context contexto, ArrayList<Projeto> elementos){
        super(contexto, R.layout.linha_lista, elementos);
        this.contexto = contexto;
        this.elementos = elementos;
    }

    @Override
    public View getView(final int position, View ContentView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha_lista, parent, false);

        TextView titulo = (TextView) rowView.findViewById(R.id.txt_titulo);
        TextView sala = (TextView) rowView.findViewById(R.id.txt_sala);
        TextView tempVisita = (TextView) rowView.findViewById(R.id.txt_temp_visita);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.img_identificacao);
        ImageButton deletar = rowView.findViewById(R.id.btn_deletar);

        titulo.setText("Projeto: "+elementos.get(position).getNome());
        sala.setText("Sala: "+elementos.get(position).getSala());
        tempVisita.setText("Tempo médio de visita: "+elementos.get(position).getTempVisita());
        imagem.setImageResource(elementos.get(position).getImage());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), ActivityConteudo.class);
                it.putExtra("nome", elementos.get(position).getNome());
                it.putExtra("sala", elementos.get(position).getSala());
                it.putExtra("numContato", elementos.get(position).getNumContato());
                it.putExtra("email", elementos.get(position).getEmail());
                it.putExtra("descricao", elementos.get(position).getDescricao());
                it.putExtra("tempVisita", elementos.get(position).getTempVisita());
                contexto.startActivity(it);
            }
        });

        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                elementos.remove(position);
                notifyDataSetChanged();
            }
        });

        return rowView;
    }
}
