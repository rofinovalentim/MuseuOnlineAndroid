package com.example.rofinochungajr.museuonline.domain.model;

public class EspecieAmeaca {
    private Especie especie;
    private Ameaca ameaca;

    public EspecieAmeaca() {
    }

    public EspecieAmeaca(Especie especie, Ameaca ameaca) {
        this.especie = especie;
        this.ameaca = ameaca;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Ameaca getAmeaca() {
        return ameaca;
    }

    public void setAmeaca(Ameaca ameaca) {
        this.ameaca = ameaca;
    }

    @Override
    public String toString() {
        return "EspecieAmeaca{" +
                "especie=" + especie +
                ", ameaca=" + ameaca +
                '}';
    }
}
