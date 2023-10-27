package br.ka.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends EntityClass {

    private String nome;

    private String email;

    private String login;

    private String senha;

    private String cpf;

    private LocalDate dataNascimento;

    private String telefone;

    private String naturalidade;
}
