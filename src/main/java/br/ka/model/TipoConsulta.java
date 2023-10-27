package br.ka.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoConsulta {

    DT(0, "DT");

    private int id;
    private String label;

    TipoConsulta(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static TipoConsulta valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for (TipoConsulta tipoConsulta : TipoConsulta.values()) {
            if (id.equals(tipoConsulta.getId()))
                return tipoConsulta;
        }
        throw new IllegalArgumentException("Id inválido:" + id);
    }

}
