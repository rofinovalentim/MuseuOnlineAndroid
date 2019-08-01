package com.example.rofinochungajr.museuonline.domain.model;

public class LocalizacaoEspecie {
    private Integer idLocalizacao;
    private Regiao regiao;
    private Provincia provincia;
    private Distrito distrito;
    private Especie especie;

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Integer getIdLocalizacao() {
        return idLocalizacao;
    }

    public void setIdLocalizacao(Integer idLocalizacao) {
        this.idLocalizacao = idLocalizacao;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    @Override
    public String toString() {
        return "LocalizacaoEspecie{" +
                "idLocalizacao=" + idLocalizacao +
                ", distrito=" + distrito +
                ", especie=" + especie +
                '}';
    }
}
