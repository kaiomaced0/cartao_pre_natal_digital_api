package br.ka.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Gestacao extends EntityClass {

    private String nomeBebe;

    private String idadeGestacional;

    private LocalDate dataInicio;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Vacina vacinaDTPa;

    private Boolean realizado;

    private String observacaoFinal;

    public String getIdadeGestacional() {
        return idadeGestacional;
    }

    public void setIdadeGestacional(String idadeGestacional) {
        this.idadeGestacional = idadeGestacional;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getNomeBebe() {
        return nomeBebe;
    }

    public void setNomeBebe(String nomeBebe) {
        this.nomeBebe = nomeBebe;
    }

    public Vacina getVacinaDTPa() {
        return vacinaDTPa;
    }

    public void setVacinaDTPa(Vacina vacinaDTPa) {
        this.vacinaDTPa = vacinaDTPa;
    }

    public Boolean getRealizado() {
        return realizado;
    }

    public void setRealizado(Boolean realizado) {
        this.realizado = realizado;
    }

    public String getObservacaoFinal() {
        return observacaoFinal;
    }

    public void setObservacaoFinal(String observacaoFinal) {
        this.observacaoFinal = observacaoFinal;
    }
}
