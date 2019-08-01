package com.example.rofinochungajr.museuonline.domain.model;

public class Ordem {
    private Integer idOrdem;
    private String ordem;
    private Classe classe;

    public Integer getIdOrdem() {
        return idOrdem;
    }

    public void setIdOrdem(int idOrdem) {
        this.idOrdem = idOrdem;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }

    public Classe getIdClasse() {
        return classe;
    }

    public void setIdClasse(Classe idClasse) {
        this.classe = idClasse;
    }
}
