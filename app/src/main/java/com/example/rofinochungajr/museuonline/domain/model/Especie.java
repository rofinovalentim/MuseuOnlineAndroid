package com.example.rofinochungajr.museuonline.domain.model;

import java.io.Serializable;

public class Especie  implements Serializable {
    private Integer idEspecie;
    private String nomeEspecie;
    private Genero genero;
    private String nomeComum;
    private String habitat;
    private String coordenadas;
    private String notas;
    private String detalhes;
    private String codigo;
    private String validacao;
    private String dataCriacao;

    public int getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(int idEspecie) {
        this.idEspecie = idEspecie;
    }

    public String getNomeEspecie() {
        return nomeEspecie;
    }

    public void setNomeEspecie(String nomeEspecie) {
        this.nomeEspecie = nomeEspecie;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getNomeComum() {
        return nomeComum;
    }

    public void setNomeComum(String nomeComum) {
        this.nomeComum = nomeComum;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getValidacao() {
        return validacao;
    }

    public void setValidacao(String validacao) {
        this.validacao = validacao;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataValidacao) {
        this.dataCriacao = dataValidacao;
    }

    @Override
    public String toString() {
        return "Especie{" +
                "idEspecie=" + idEspecie +
                ", nomeEspecie='" + nomeEspecie + '\'' +
                ", genero=" + genero +
                ", nomeComum='" + nomeComum + '\'' +
                ", habitat='" + habitat + '\'' +
                ", coordenadas='" + coordenadas + '\'' +
                ", notas='" + notas + '\'' +
                ", detalhes='" + detalhes + '\'' +
                ", codigo='" + codigo + '\'' +
                ", validacao='" + validacao + '\'' +
                ", dataValidacao='" + dataCriacao + '\'' +
                '}';
    }
}
