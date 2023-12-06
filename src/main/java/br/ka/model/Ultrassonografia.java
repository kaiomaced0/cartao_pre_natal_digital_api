package br.ka.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Ultrassonografia extends EntityClass {

    private String idadeGestacional;

    private String observacao;

    private String doppler;

    private String liq;

    private String igdum;

    private String placenta;

    private String linkArquivo;

    private LocalDate data;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDoppler() {
        return doppler;
    }

    public void setDoppler(String doppler) {
        this.doppler = doppler;
    }

    public String getLiq() {
        return liq;
    }

    public void setLiq(String liq) {
        this.liq = liq;
    }

    public String getIgdum() {
        return igdum;
    }

    public void setIgdum(String igdum) {
        this.igdum = igdum;
    }

    public String getPlacenta() {
        return placenta;
    }

    public void setPlacenta(String placenta) {
        this.placenta = placenta;
    }

    public String getIdadeGestacional() {
        return idadeGestacional;
    }

    public void setIdadeGestacional(String idadeGestacional) {
        this.idadeGestacional = idadeGestacional;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getLinkArquivo() {
        return linkArquivo;
    }

    public void setLinkArquivo(String linkArquivo) {
        this.linkArquivo = linkArquivo;
    }
}
