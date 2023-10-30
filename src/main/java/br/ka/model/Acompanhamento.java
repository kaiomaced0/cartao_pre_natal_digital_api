package br.ka.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Acompanhamento extends EntityClass {

    private String idadeGestacional;

    private String observacao;

    private String dados;

    private Double peso;

}
