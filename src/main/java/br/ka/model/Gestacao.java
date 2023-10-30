package br.ka.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Gestacao extends EntityClass {

    private String nomeBebe;

    private Vacina vacinaDTPa;

    private Boolean realizado;

    private String observacaoFinal;

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
