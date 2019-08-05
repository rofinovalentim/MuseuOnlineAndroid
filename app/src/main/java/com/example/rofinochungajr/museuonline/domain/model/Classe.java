package com.example.rofinochungajr.museuonline.domain.model;

public class Classe {
    private Integer idClasse;
    private String classe;
    private Filo filo;

    public Integer getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Integer idClasse) {
        this.idClasse = idClasse;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Filo getFilo() {
        return filo;
    }

    public void setFilo(Filo filo) {
        this.filo = filo;
    }

    @Override
    public String toString() {
        return "Classe{" +
                "idClasse=" + idClasse +
                ", classe='" + classe + '\'' +
                ", filo=" + filo +
                '}';
    }
}
