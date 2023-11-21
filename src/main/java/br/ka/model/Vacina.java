package br.ka.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vacina extends EntityClass {

    private String nome;

    private Double quantidadeDoses;

    private Double doseAtual;

    private String nomeProfissionalRealizouVacina;

    private String localVacinaRealizada;

    private String loteVacina;

    private LocalDate dataRealizada;

    @Enumerated(EnumType.STRING)
    private TipoVacina tipoVacina;

    public LocalDate getDataRealizada() {
        return dataRealizada;
    }

    public void setDataRealizada(LocalDate dataRealizada) {
        this.dataRealizada = dataRealizada;
    }

    public TipoVacina getTipoVacina() {
        return tipoVacina;
    }

    public void setTipoVacina(TipoVacina tipoVacina) {
        this.tipoVacina = tipoVacina;
    }

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
