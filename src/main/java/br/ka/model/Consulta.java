package br.ka.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Consulta extends EntityClass {

    private Usuario usuario;

    private TipoConsulta tipoConsulta;

    private Medico medico;

    private String observacao;

    
}
