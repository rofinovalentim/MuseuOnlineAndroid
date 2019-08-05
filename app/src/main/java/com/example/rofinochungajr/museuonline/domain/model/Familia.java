package com.example.rofinochungajr.museuonline.domain.model;

public class Familia {
    private Integer idFamilia;
    private String familia;
    private Ordem ordem;

    public Integer getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Integer idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public Ordem getOrdem() {
        return ordem;
    }

    public void setOrdem(Ordem ordem) {
        this.ordem = ordem;
    }

    @Override
    public String toString() {
        return "Familia{" +
                "idFamilia=" + idFamilia +
                ", familia='" + familia + '\'' +
                ", ordem=" + ordem +
                '}';
    }
}
