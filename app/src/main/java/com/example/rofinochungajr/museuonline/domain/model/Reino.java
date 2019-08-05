package com.example.rofinochungajr.museuonline.domain.model;

public class Reino {
    private  Integer idReino;
    private String reino;

    public Integer getIdReino() {
        return idReino;
    }

    public void setIdReino(Integer idReino) {
        this.idReino = idReino;
    }

    public String getReino() {
        return reino;
    }

    public void setReino(String reino) {
        this.reino = reino;
    }

    @Override
    public String toString() {
        return "Reino{" +
                "idReino=" + idReino +
                ", reino='" + reino + '\'' +
                '}';
    }
}
