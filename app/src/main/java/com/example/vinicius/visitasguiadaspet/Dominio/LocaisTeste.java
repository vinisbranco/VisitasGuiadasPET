package com.example.vinicius.visitasguiadaspet.Dominio;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vinicius on 06/12/2017.
 */

public class LocaisTeste {

    private SQLiteDatabase db;
    private BancoTeste helper;

    public LocaisTeste(Context context){
        helper = new BancoTeste(context);
        db = helper.getDatabase();
    }

    public List<JSONObject> allLocais(){

        List<JSONObject> result = new ArrayList<JSONObject>();

        Cursor cursor = db.query("LOCAIS",new String[]{"nome","sala","email","tags","tempo_visita"},null
                ,null,null,null, "sala ASC");

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            JSONObject obj = new JSONObject();

            try{
                obj.put("nome", cursor.getString(0));
                obj.put("sala", cursor.getString(1));
                obj.put("email", cursor.getString(2));
                obj.put("tags", cursor.getString(3));
                obj.put("tempo_visita", cursor.getString(4));
            }catch(JSONException e){
                e.printStackTrace();
            }

            result.add(obj);

            cursor.moveToNext();
        }

        cursor.close();
        return result;
    }




}
