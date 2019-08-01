package com.example.rofinochungajr.museuonline.domain.model;

public class CadastroPedido {
    private Integer idCadastroPedido;
    private String email;
    private String password;

    public Integer getIdCadastroPedido() {
        return idCadastroPedido;
    }

    public void setIdCadastroPedido(Integer idCadastroPedido) {
        this.idCadastroPedido = idCadastroPedido;
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

    public void setPassword(String password) {
        this.password = password;
    }
}
