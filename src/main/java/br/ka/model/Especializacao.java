package br.ka.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Especializacao {

    OBSTETRA(0, "Obstetra");

    private int id;
    private String label;

    Especializacao(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Especializacao valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for (Especializacao especializacao : Especializacao.values()) {
            if (id.equals(especializacao.getId()))
                return especializacao;
        }
        throw new IllegalArgumentException("Id inválido:" + id);
    }

}
