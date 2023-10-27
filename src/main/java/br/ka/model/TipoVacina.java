package br.ka.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoVacina {

    DT(0, "DT");

    private int id;
    private String label;

    TipoVacina(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static TipoVacina valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for (TipoVacina tipoVacina : TipoVacina.values()) {
            if (id.equals(tipoVacina.getId()))
                return tipoVacina;
        }
        throw new IllegalArgumentException("Id inválido:" + id);
    }

}
