package com.example.rofinochungajr.museuonline.domain.model;

public class MetodoDePreservacao {
    private  Integer idMetodo;
    private  String metodo;

    public MetodoDePreservacao() {
    }

    public MetodoDePreservacao(Integer idMetodo, String metodo) {
        this.idMetodo = idMetodo;
        this.metodo = metodo;
    }

    public Integer getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(Integer idMetodo) {
        this.idMetodo = idMetodo;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    @Override
    public String toString() {
        return "MetodoDePreservacao{" +
                "idMetodo=" + idMetodo +
                ", metodo='" + metodo + '\'' +
                '}';
    }
}
