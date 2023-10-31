package br.ka.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Consulta extends EntityClass {

    @ManyToOne
    @JoinColumn(name = "usuario_consulta")
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private TipoConsulta tipoConsulta;

    @JoinColumn(name = "medico_consulta")
    @ManyToOne
    private Medico medico;

    private String observacao;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(TipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
