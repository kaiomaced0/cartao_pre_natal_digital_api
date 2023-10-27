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
    
}
