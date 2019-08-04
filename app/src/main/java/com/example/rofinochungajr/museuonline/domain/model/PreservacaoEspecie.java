package com.example.rofinochungajr.museuonline.domain.model;

public class PreservacaoEspecie {
    private Integer idPreservacaoEspecie;
    private MetodoDePreservacao metodoDePreservacao;
    private Especie especie;


    public PreservacaoEspecie() {
    }

    public PreservacaoEspecie(Integer idPreservacaoEspecie, MetodoDePreservacao metodoDePreservacao, Especie especie) {
        this.idPreservacaoEspecie = idPreservacaoEspecie;
        this.metodoDePreservacao = metodoDePreservacao;
        this.especie = especie;
    }

    public Integer getIdPreservacaoEspecie() {
        return idPreservacaoEspecie;
    }

    public void setIdPreservacaoEspecie(Integer idPreservacaoEspecie) {
        this.idPreservacaoEspecie = idPreservacaoEspecie;
    }

    public MetodoDePreservacao getMetodoDePreservacao() {
        return metodoDePreservacao;
    }

    public void setMetodoDePreservacao(MetodoDePreservacao metodoDePreservacao) {
        this.metodoDePreservacao = metodoDePreservacao;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    @Override
    public String toString() {
        return "PreservacaoEspecie{" +
                "idPreservacaoEspecie=" + idPreservacaoEspecie +
                ", metodoDePreservacao=" + metodoDePreservacao +
                ", especie=" + especie +
                '}';
    }
}
