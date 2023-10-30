package br.ka.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Exame extends EntityClass {

    private String tipoExame;

    private String localExameRealizado;

    private String observacao;

    public String getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    public String getLocalExameRealizado() {
        return localExameRealizado;
    }

    public void setLocalExameRealizado(String localExameRealizado) {
        this.localExameRealizado = localExameRealizado;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
