package br.ka.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vacina extends EntityClass {

    private String nome;

    private Double quantidadeDoses;

    private Double doseAtual;

    private String nomeProfissionalRealizouVacina;

    private String localVacinaRealizada;

    private String loteVacina;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getQuantidadeDoses() {
        return quantidadeDoses;
    }

    public void setQuantidadeDoses(Double quantidadeDoses) {
        this.quantidadeDoses = quantidadeDoses;
    }

    public Double getDoseAtual() {
        return doseAtual;
    }

    public void setDoseAtual(Double doseAtual) {
        this.doseAtual = doseAtual;
    }

    public String getNomeProfissionalRealizouVacina() {
        return nomeProfissionalRealizouVacina;
    }

    public void setNomeProfissionalRealizouVacina(String nomeProfissionalRealizouVacina) {
        this.nomeProfissionalRealizouVacina = nomeProfissionalRealizouVacina;
    }

    public String getLocalVacinaRealizada() {
        return localVacinaRealizada;
    }

    public void setLocalVacinaRealizada(String localVacinaRealizada) {
        this.localVacinaRealizada = localVacinaRealizada;
    }

    public String getLoteVacina() {
        return loteVacina;
    }

    public void setLoteVacina(String loteVacina) {
        this.loteVacina = loteVacina;
    }
}
