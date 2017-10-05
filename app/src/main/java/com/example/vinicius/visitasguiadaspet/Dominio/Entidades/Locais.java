package com.example.vinicius.visitasguiadaspet.Dominio.Entidades;

/**
 * Created by vinicius on 05/10/17.
 */

public class Locais {
    private char id;
    private String nSala;
    private String nome;
    private int numContato;
    private String email;
    private int tempVisit;
    private String descricao;

    public Locais(char id, String nSala, String nome, int numContato , String email, int tempVisit, String descricao){
        this.id = id;
        this.nSala = nSala;
        this.nome = nome;
        this.numContato = numContato;
        this.email = email;
        this.tempVisit = tempVisit;
        this.descricao = descricao;
    }

    public char getId() {
        return id;
    }
    public void setId(char id) {
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

    public int getNumContato() {
        return numContato;
    }
    public void setNumContato(int numContato) {
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
}
