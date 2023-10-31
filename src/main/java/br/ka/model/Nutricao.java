package br.ka.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Nutricao extends EntityClass {

    private String titulo;

    private String descricao;

    private Boolean especifico;

    @OneToOne
    private Mamae mamae;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getEspecifico() {
        return especifico;
    }

    public void setEspecifico(Boolean especifico) {
        this.especifico = especifico;
    }

    public Mamae getMamae() {
        return mamae;
    }

    public void setMamae(Mamae mamae) {
        this.mamae = mamae;
    }
}
