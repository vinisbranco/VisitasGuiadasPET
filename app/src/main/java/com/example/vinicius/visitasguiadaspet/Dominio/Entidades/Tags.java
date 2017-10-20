package com.example.vinicius.visitasguiadaspet.Dominio.Entidades;

/**
 * Created by vinicius on 11/10/17.
 */

public class Tags {

    private int idTags;
    private String Tags;
    private Locais locais;

    public Tags(){

    }

    public Tags(int idTags, String Tags, Locais locais){
        this.idTags = idTags;
        this.Tags = Tags;
        this.locais = locais;
    }

    public int getIdTags() {
        return idTags;
    }

    public void setIdTags(int idTags) {
        this.idTags = idTags;
    }

    public String getTags() {
        return Tags;
    }

    public void setTags(String tags) {
        Tags = tags;
    }

    public Locais getLocais() {
        return locais;
    }

    public void setLocais(Locais locais) {
        this.locais = locais;
    }

    @Override
    public String toString() {
        return Tags;
    }
}
