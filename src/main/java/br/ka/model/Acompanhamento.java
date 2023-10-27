package br.ka.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Acompanhamento extends EntityClass {

    private String idadeGestacional;

    private String observacao;

    private String dados;

    private Double peso;

}
