package com.example.vinicius.visitasguiadaspet.Dominio.Entidades;

/**
 * Created by vinicius on 05/10/17.
 */

public class Locais {
    private int id;
    private String nSala;
    private String nome;
    private String numContato;
    private String email;
    private int tempVisit;
    private String descricao;

    public Locais(){

    }

    public Locais(int id, String nSala, String nome, String numContato , String email, int tempVisit, String descricao){
        this.id = id;
        this.nSala = nSala;
        this.nome = nome;
        this.numContato = numContato;
        this.email = email;
        this.tempVisit = tempVisit;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getnSala() {
        return nSala;
    }
    public void setnSala(String nSala) {
        this.nSala = nSala;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumContato() {
        return numContato;
    }
    public void setNumContato(String numContato) {
        this.numContato = numContato;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getTempVisit() {
        return tempVisit;
    }
    public void setTempVisit(int tempVisit) {
        this.tempVisit = tempVisit;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return nSala + " - " + nome + "\n" + numContato + " - " + email + "\n" + tempVisit + "\n" + descricao;
    }
}
