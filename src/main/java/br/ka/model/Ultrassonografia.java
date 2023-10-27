package br.ka.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Ultrassonografia extends EntityClass {

    private String idadeGestacional;

    private String observacao;

    private String linkArquivo;
    
}
