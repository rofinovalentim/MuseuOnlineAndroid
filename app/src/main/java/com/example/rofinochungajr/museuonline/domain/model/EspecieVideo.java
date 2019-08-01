package com.example.rofinochungajr.museuonline.domain.model;

public class EspecieVideo {
    private Integer idVideo;
    private String video;
    private Especie especie;

    public Integer getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(Integer idVideo) {
        this.idVideo = idVideo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    @Override
    public String toString() {
        return "EspecieVideo{" +
                "idVideo=" + idVideo +
                ", video='" + video + '\'' +
                ", especie=" + especie +
                '}';
    }
}
