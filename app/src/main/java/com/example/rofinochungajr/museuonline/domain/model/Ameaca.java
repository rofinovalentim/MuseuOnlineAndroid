package com.example.rofinochungajr.museuonline.domain.model;

public class Ameaca {
    private Integer idAmeaca;
    private String ameaca;

    public Integer getIdAmeaca() {
        return idAmeaca;
    }

    public void setIdAmeaca(Integer idAmeaca) {
        this.idAmeaca = idAmeaca;
    }

    public String getAmeaca() {
        return ameaca;
    }

    public void setAmeaca(String ameaca) {
        this.ameaca = ameaca;
    }

    @Override
    public String toString() {
        return ameaca;
    }
}
