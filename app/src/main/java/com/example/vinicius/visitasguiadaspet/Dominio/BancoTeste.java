package com.example.vinicius.visitasguiadaspet.Dominio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vinicius on 06/12/2017.
 */

public class BancoTeste extends SQLiteOpenHelper {
    public BancoTeste(Context context){
        super(context, "locais.sqlite", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE LOCAIS("+
                "id INT AUTO_INCREMENT, "+
                "nome VARCHAR(100), "+
                "sala INTEGER, "+
                "email VARCHAR(50), "+
                "tags VARCHAR(100), "+
                "tempo_visita INTEGER, "+
                "primary key(id)"+");");
        preencherTabela(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS LOCAIS");
        onCreate(db);
    }

    public SQLiteDatabase getDatabase(){
        return this.getWritableDatabase();
    }

    public void removerBanco(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS LOCAIS");
    }

    public static void preencherTabela(SQLiteDatabase db) {
        Cursor cur = db.rawQuery("SELECT COUNT(*) FROM LOCAIS", null);

        ContentValues values = new ContentValues();

        values.put("nome","PET");
        values.put("sala",701);
        values.put("email", "pet@pucrs.br");
        values.put("tags", "Outros");
        values.put("tempo_visita", 10);
        db.insert("LOCAIS", null, values);

        values.put("nome","AGES");
        values.put("sala",107);
        values.put("email", "ages@pucrs.br");
        values.put("tags", "Engenharia de Software");
        values.put("tempo_visita", 10);
        db.insert("LOCAIS", null, values);

        values.put("nome","CePES");
        values.put("sala",106);
        values.put("email", "cepes@pucrs.br");
        values.put("tags", "Virtualização");
        values.put("tempo_visita",15);
        db.insert("LOCAIS", null, values);

        values.put("nome","SMART");
        values.put("sala",627);
        values.put("email", "smart@pucrs.br");
        values.put("tags", "Inteligência Artificial, Robótica");
        values.put("tempo_visita",15);
        db.insert("LOCAIS", null, values);

        values.put("nome","DaVint");
        values.put("sala",654);
        values.put("email", "daVint@pucrs.br");
        values.put("tags", "Computação Gráfica");
        values.put("tempo_visita",20);
        db.insert("LOCAIS", null, values);

        values.put("nome","GPIN");
        values.put("sala",725);
        values.put("email", "gpin@pucrs.br");
        values.put("tags", "Processamento de Dados");
        values.put("tempo_visita",15);
        db.insert("LOCAIS", null, values);

        values.put("nome","LABIO");
        values.put("sala",602);
        values.put("email", "labio@pucrs.br");
        values.put("tags", "Simulação");
        values.put("tempo_visita",15);
        db.insert("LOCAIS", null, values);

        values.put("nome","GRV");
        values.put("sala",625);
        values.put("email", "grv@pucrs.br");
        values.put("tags", "Realidade Virtual");
        values.put("tempo_visita",15);
        db.insert("LOCAIS", null, values);

        values.put("nome","INCER");
        values.put("sala",629);
        values.put("email", "incer@pucrs.br");
        values.put("tags", "Saúde");
        values.put("tempo_visita",20);
        db.insert("LOCAIS", null, values);

        values.put("nome","PLN");
        values.put("sala",630);
        values.put("email", "pln@pucrs.br");
        values.put("tags", "Engenharia de software,Processamento de Dados");
        values.put("tempo_visita",15);
        db.insert("LOCAIS", null, values);

        values.put("nome","LSHV");
        values.put("sala",653);
        values.put("email", "lshv@pucrs.br");
        values.put("tags", "Virtualização");
        values.put("tempo_visita",15);
        db.insert("LOCAIS", null, values);

        values.put("nome","GSE");
        values.put("sala",721);
        values.put("email", "gse@pucrs.br");
        values.put("tags", "Virtualização,Internet das Coisas,Hardware");
        values.put("tempo_visita",10);
        db.insert("LOCAIS", null, values);

        values.put("nome","GAPH");
        values.put("sala",726);
        values.put("email", "gaph@pucrs.br");
        values.put("tags", "Hardware");
        values.put("tempo_visita",15);
        db.insert("LOCAIS", null, values);

    }
}

