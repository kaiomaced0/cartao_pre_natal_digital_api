package br.ka.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Ultrassonografia extends EntityClass {

    private String idadeGestacional;

    private String observacao;

    private String linkArquivo;

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
