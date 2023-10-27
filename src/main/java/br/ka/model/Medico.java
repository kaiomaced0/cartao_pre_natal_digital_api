package br.ka.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Medico extends Usuario {

    private Especializacao especializacao;

    private String crm;
}
