package br.ka.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Mamae extends Usuario {

    private Boolean emGestacao;

    @OneToMany
    @JoinColumn(name = "vacina_mamae")
    private List<Vacina> vacinas;

    @OneToMany
    @JoinColumn(name = "consulta_mamae")
    private List<Consulta> consultas;

    @OneToMany
    @JoinColumn(name = "exame_mamae")
    private List<Exame> exames;

    @OneToMany
    @JoinColumn(name = "ultrassonografia_mamae")
    private List<Ultrassonografia> ultrassonografias;

    private String convenio;

    private String contatoEmergencia;

    @OneToOne
    @JoinColumn(name = "gestacao_mamae")
    private Gestacao gestacao;

    @OneToMany
    @JoinColumn(name = "mamae_gestacao")
    private List<Gestacao> gestacoes;

    @ManyToOne
    @JoinColumn(name = "medico_medico")
    private Medico medico;

    private String observacoes;

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public List<Gestacao> getGestacoes() {
        return gestacoes;
    }

    public void setGestacoes(List<Gestacao> gestacoes) {
        this.gestacoes = gestacoes;
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Boolean getEmGestacao() {
        return emGestacao;
    }

    public void setEmGestacao(Boolean emGestacao) {
        this.emGestacao = emGestacao;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

    public List<Ultrassonografia> getUltrassonografias() {
        return ultrassonografias;
    }

    public void setUltrassonografias(List<Ultrassonografia> ultrassonografias) {
        this.ultrassonografias = ultrassonografias;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public Gestacao getGestacao() {
        return gestacao;
    }

    public void setGestacao(Gestacao gestacao) {
        this.gestacao = gestacao;
    }

    public String getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(String contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }
}
