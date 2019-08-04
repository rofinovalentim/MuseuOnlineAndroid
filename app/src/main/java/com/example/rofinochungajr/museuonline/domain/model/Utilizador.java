package com.example.rofinochungajr.museuonline.domain.model;

public class Utilizador {

    private Integer idUtilizador;
    private String nomeCompleto;
    private String email;
    private String password;
    private TipoUtilizador tipoUtilizador;

    public  Utilizador(){

    }

    public Utilizador(Integer idUtilizador, String nomeCompleto, String email, String password, TipoUtilizador tipoUtilizador) {
        this.idUtilizador = idUtilizador;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.password = password;
        this.tipoUtilizador = tipoUtilizador;
    }

    public TipoUtilizador getTipoUtilizador() {
        return tipoUtilizador;
    }

    public void setTipoUtilizador(TipoUtilizador tipoUtilizador) {
        this.tipoUtilizador = tipoUtilizador;
    }

    public Integer getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Integer id) {
        this.idUtilizador = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
