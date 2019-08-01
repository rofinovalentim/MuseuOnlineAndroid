package com.example.rofinochungajr.museuonline.domain.model;

public class Provincia {
    private int idProvicia;
    private  Regiao regiao;
    private String provincia;

    public int getIdProvicia() {
        return idProvicia;
    }

    public void setIdProvicia(Integer idProvicia) {
        this.idProvicia = idProvicia;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    @Override
    public String toString(){
        return provincia;
    }
}
