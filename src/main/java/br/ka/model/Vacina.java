package br.ka.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vacina extends EntityClass {

    private String nome;

    private Integer quantidadeDoses;

    private Integer doseAtual;

    private String nomeProfissionalRealizouVacina;

    private String localVacinaRealizada;

    private String loteVacina;

    private LocalDate dataRealizada;


    public LocalDate getDataRealizada() {
        return dataRealizada;
    }

    public void setDataRealizada(LocalDate dataRealizada) {
        this.dataRealizada = dataRealizada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeDoses() {
        return quantidadeDoses;
    }

    public void setQuantidadeDoses(Integer quantidadeDoses) {
        this.quantidadeDoses = quantidadeDoses;
    }

    public Integer getDoseAtual() {
        return doseAtual;
    }

    public void setDoseAtual(Integer doseAtual) {
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
