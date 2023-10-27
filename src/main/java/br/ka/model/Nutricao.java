package br.ka.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Nutricao extends EntityClass {

    private String titulo;

    private String descricao;

    private Boolean especifico;

    private Mamae mamae;
    
}
