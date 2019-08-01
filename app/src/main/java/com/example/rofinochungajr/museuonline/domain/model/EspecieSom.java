package com.example.rofinochungajr.museuonline.domain.model;

public class EspecieSom {
    private Integer idSom;
    private String som;
    private Especie especie;

    public Integer getIdSom() {
        return idSom;
    }

    public void setIdSom(Integer idSom) {
        this.idSom = idSom;
    }

    public String getSom() {
        return som;
    }

    public void setSom(String som) {
        this.som = som;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    @Override
    public String toString() {
        return "EspecieSom{" +
                "idSom=" + idSom +
                ", som='" + som + '\'' +
                ", especie=" + especie +
                '}';
    }
}
