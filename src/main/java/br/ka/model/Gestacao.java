package br.ka.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Gestacao extends EntityClass {

    private String nomeBebe;

    private Vacina vacinaDTPa;


}
