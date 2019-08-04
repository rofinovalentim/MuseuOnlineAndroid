package com.example.rofinochungajr.museuonline.domain.model;

public class QuemEncontrou {
    private Pessoa pessoa;
    private Especie especie;

    public QuemEncontrou() {
    }

    public QuemEncontrou(Pessoa pessoa, Especie especie) {
        this.pessoa = pessoa;
        this.especie = especie;
    }
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    @Override
    public String toString() {
        return "QuemEncontrou{" +
                "pessoa=" + pessoa +
                ", especie=" + especie +
                '}';
    }
}
