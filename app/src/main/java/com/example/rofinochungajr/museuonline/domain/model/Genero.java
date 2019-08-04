package com.example.rofinochungajr.museuonline.domain.model;

import java.io.Serializable;

public class Genero implements Serializable {
    private Integer idGenero;
    private String genero;
    private Familia idFamilia;


    public Integer getIdGenero() {
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

    @Override
    public String toString() {
        return genero;
    }
}
