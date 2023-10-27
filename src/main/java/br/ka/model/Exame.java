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
}
