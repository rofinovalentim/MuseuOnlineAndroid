package com.example.rofinochungajr.museuonline.domain.model;

import java.io.Serializable;

public class Genero implements Serializable {
    private Integer idGenero;
    private String genero;
    private Familia familia;


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

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "idGenero=" + idGenero +
                ", genero='" + genero + '\'' +
                ", idFamilia=" + familia +
                '}';
    }
}
