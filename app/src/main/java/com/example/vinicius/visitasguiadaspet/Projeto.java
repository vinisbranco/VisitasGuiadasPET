package com.example.vinicius.visitasguiadaspet;

/**
 * Created by Vinicius on 16/10/2017.
 */

public class Projeto {
    private String nome;
    private final String sala;
    private final String numContato;
    private final String email;
    private final String tempVisita;
    private final String descricao;
    private final String tags;
    private final int image;

    public Projeto(String nome, String sala, String numContato, String email, String tempVisita, String descricao, int image, String tags){
        this.nome = nome;
        this.sala = sala;
        this.numContato = numContato;
        this.email = email;
        this.tempVisita = tempVisita;
        this.descricao = descricao;
        this.image = image;
        this.tags = tags;
    }


    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getImage() {
        return image;
    }

    public String getSala() {
        return sala;
    }

    public String getNumContato() {
        return numContato;
    }

    public String getEmail() {
        return email;
    }

    public String getTempVisita() {
        return tempVisita;
    }

    public String getTags() { return tags; }
}
