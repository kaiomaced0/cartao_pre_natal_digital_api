package br.ka.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Gestante extends EntityClass {

    @Column(nullable = false, name = "cpf")
    private String cpf;

    @Column(nullable = false, name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "naturalidade")
    private String naturalidade;

    @Column(name = "convenio")
    private String convenio;

    @Column(name = "vacina_dtpa")
    private Boolean vacinaDTPA;

    @Column(name = "h1n1")
    private Boolean h1n1;

    @ElementCollection
    @Column(name = "contato_emergencia")
    private List<String> contatosEmergencia;

    @Column(name = "gestacao")
    private Integer gestacao;

    @Column(name = "parto")
    private Integer parto;

    @Column(name = "aborto")
    private Integer aborto;

    @Column(name = "ect")
    private Integer ect;

    @Column(name = "tipo_sanguineo")
    private String tipoSanguineo;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public Boolean getVacinaDTPA() {
        return vacinaDTPA;
    }

    public void setVacinaDTPA(Boolean vacinaDTPA) {
        this.vacinaDTPA = vacinaDTPA;
    }

    public Boolean getH1n1() {
        return h1n1;
    }

    public void setH1n1(Boolean h1n1) {
        this.h1n1 = h1n1;
    }

    public List<String> getContatosEmergencia() {
        return contatosEmergencia;
    }

    public void setContatosEmergencia(List<String> contatosEmergencia) {
        this.contatosEmergencia = contatosEmergencia;
    }

    public Integer getGestacao() {
        return gestacao;
    }

    public void setGestacao(Integer gestacao) {
        this.gestacao = gestacao;
    }

    public Integer getParto() {
        return parto;
    }

    public void setParto(Integer parto) {
        this.parto = parto;
    }

    public Integer getAborto() {
        return aborto;
    }

    public void setAborto(Integer aborto) {
        this.aborto = aborto;
    }

    public Integer getEct() {
        return ect;
    }

    public void setEct(Integer ect) {
        this.ect = ect;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

}
