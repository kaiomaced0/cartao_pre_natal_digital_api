package br.ka.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Mamae extends Usuario {

    private Boolean emGestacao;

    private List<Acompanhamento> acompanhamentos;

    private List<Exame> exames;

    private List<Ultrassonografia> ultrassonografias;

    private String convenio;

    private List<String> contatoEmergencia;

}
