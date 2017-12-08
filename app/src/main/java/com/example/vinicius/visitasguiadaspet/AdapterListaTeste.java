package com.example.vinicius.visitasguiadaspet;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Vinicius on 06/12/2017.
 */

public class AdapterListaTeste extends ArrayAdapter<JSONObject> {

    private Context contexto;
    private List<JSONObject> locais;

    public AdapterListaTeste(Context contexto, List<JSONObject> locais){
        super(contexto, R.layout.linha_teste, locais);
        this.contexto = contexto;
        this.locais = locais;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha_teste, parent, false);

        TextView nome = (TextView) rowView.findViewById(R.id.txt_nome_teste);
        TextView tags = (TextView) rowView.findViewById(R.id.txt_tags_teste);
        TextView email = (TextView) rowView.findViewById(R.id.txt_email_teste);
        TextView temp = (TextView) rowView.findViewById(R.id.txt_tempVisita_teste);
        TextView sala = (TextView) rowView.findViewById(R.id.txt_sala_teste);

        try{
            nome.setText(locais.get(position).getString("nome"));
            sala.setText(locais.get(position).getString("sala"));
            tags.setText("Tags: "+locais.get(position).getString("tags"));
            email.setText("E-mail: "+locais.get(position).getString("email"));
            temp.setText("Tempo: "+locais.get(position).getString("tempo_visita"));
        }catch (Throwable e){

        }

        return rowView;

    }
}
