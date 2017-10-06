package com.example.vinicius.visitasguiadaspet.Dominio.Entidades;

/**
 * Created by vinicius on 06/10/17.
 */

public class Horarios{
    private int idhor;
    private String DiaSem;
    private String HorEntrManh;
    private String HorSaiManh;
    private String HorEntrTar;
    private String HorSaiTar;
    private Locais locais;

    public Horarios(int idhor, String DiaSem, String HorEntrManh, String HorSaiManh, String HorEntrTar, String HorSaiTar, Locais locais){
        this.idhor = idhor;
        this.DiaSem = DiaSem;
        this.HorEntrManh = HorEntrManh;
        this.HorSaiManh = HorSaiManh;
        this.HorEntrTar = HorEntrTar;
        this.HorSaiTar = HorSaiTar;
        this.locais = locais;
    }

    public int getIdhor() {
        return idhor;
    }

    public String getDiaSem() {
        return DiaSem;
    }

    public String getHorEntrManh() {
        return HorEntrManh;
    }

    public String getHorSaiManh() {
        return HorSaiManh;
    }

    public String getHorEntrTar() {
        return HorEntrTar;
    }

    public String getHorSaiTar() {
        return HorSaiTar;
    }

    public Locais getLocais() {
        return locais;
    }

    public void setDiaSem(String diaSem) {
        DiaSem = diaSem;
    }

    public void setHorEntrManh(String horEntrManh) {
        HorEntrManh = horEntrManh;
    }

    public void setHorSaiManh(String horSaiManh) {
        HorSaiManh = horSaiManh;
    }

    public void setHorEntrTar(String horEntrTar) {
        HorEntrTar = horEntrTar;
    }

    public void setHorSaiTar(String horSaiTar) {
        HorSaiTar = horSaiTar;
    }

    public void setIdhor(int idhor) {
        this.idhor = idhor;
    }

    public void setLocais(Locais locais) {
        this.locais = locais;
    }
}
