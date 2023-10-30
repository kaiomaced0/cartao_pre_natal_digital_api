package br.ka.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Acompanhamento extends EntityClass {

    private String idadeGestacional;

    private String observacao;

    private String dados;

    private Double peso;

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

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
