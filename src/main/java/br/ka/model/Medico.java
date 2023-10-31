package br.ka.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Medico extends Usuario {

    @Column(name = "lista_especializacao_medico")
    private List<Especializacao> especializacoes;

    private String crm;

    public List<Especializacao> getEspecializacoes() {
        return especializacoes;
    }

    public void setEspecializacoes(List<Especializacao> especializacoes) {
        this.especializacoes = especializacoes;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
}
