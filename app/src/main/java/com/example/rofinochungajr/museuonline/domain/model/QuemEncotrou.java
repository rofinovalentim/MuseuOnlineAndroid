package com.example.rofinochungajr.museuonline.domain.model;

public class QuemEncotrou {
    private Pessoa pessoa;
    private Especie especie;

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
        return "QuemEncotrou{" +
                "pessoa=" + pessoa +
                ", especie=" + especie +
                '}';
    }
}
