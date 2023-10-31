package br.ka.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Mamae extends Usuario {

    private Boolean emGestacao;

    @OneToMany
    @JoinColumn(name = "lista_acompanhamento_mamae")
    private List<Acompanhamento> acompanhamentos;

    @OneToMany
    @JoinColumn(name = "lista_exame_mamae")
    private List<Exame> exames;

    @OneToMany
    @JoinColumn(name = "lista_ultrassonografia_mamae")
    private List<Ultrassonografia> ultrassonografias;

    private String convenio;


    private List<String> contatoEmergencia;

    @OneToOne
    private Gestacao gestacao;

    public Boolean getEmGestacao() {
        return emGestacao;
    }

    public void setEmGestacao(Boolean emGestacao) {
        this.emGestacao = emGestacao;
    }

    public List<Acompanhamento> getAcompanhamentos() {
        return acompanhamentos;
    }

    public void setAcompanhamentos(List<Acompanhamento> acompanhamentos) {
        this.acompanhamentos = acompanhamentos;
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

    public List<String> getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(List<String> contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    public Gestacao getGestacao() {
        return gestacao;
    }

    public void setGestacao(Gestacao gestacao) {
        this.gestacao = gestacao;
    }
}
