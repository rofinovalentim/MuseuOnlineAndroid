package com.example.rofinochungajr.museuonline.domain.model;

public class Genero {
    private int idGenero;
    private String genero;
    private Familia idFamilia;


    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Familia getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Familia idFamilia) {
        this.idFamilia = idFamilia;
    }
}
