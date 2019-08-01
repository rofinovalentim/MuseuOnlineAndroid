package com.example.rofinochungajr.museuonline.domain.model;

public class Regiao {
    private Integer idRegiao;
    private String regiao;

    public Integer getIdRegiao() {
        return idRegiao;
    }

    public void setIdRegiao(Integer idRegiao) {
        this.idRegiao = idRegiao;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    @Override
    public String toString(){
        return regiao;
    }
}
