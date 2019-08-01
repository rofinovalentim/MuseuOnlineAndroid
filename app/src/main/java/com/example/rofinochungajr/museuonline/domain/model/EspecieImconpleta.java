package com.example.rofinochungajr.museuonline.domain.model;

public class EspecieImconpleta {
    private Especie especie;
    private Reino reino;
    private Filo filo;
    private Ordem ordem;
    private Familia familia;
    private Classe classe;

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Reino getReino() {
        return reino;
    }

    public void setReino(Reino reino) {
        this.reino = reino;
    }

    public Filo getFilo() {
        return filo;
    }

    public void setFilo(Filo filo) {
        this.filo = filo;
    }

    public Ordem getOrdem() {
        return ordem;
    }

    public void setOrdem(Ordem ordem) {
        this.ordem = ordem;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "EspecieImconpleta{" +
                "especie=" + especie +
                ", reino=" + reino +
                ", filo=" + filo +
                ", ordem=" + ordem +
                ", familia=" + familia +
                ", classe=" + classe +
                '}';
    }
}
