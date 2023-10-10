package br.ka.model;

public enum Vacina {
    VACINACAO_DT(1, "Vacinação DT"),
    HEPATITE_B(2, "Hepatite B");

    private final int id;
    private final String label;

    Vacina(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Vacina valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for (Vacina vacina : Vacina.values()) {
            if (id.equals(vacina.getId()))
                return vacina;
        }
        throw new IllegalArgumentException("Id inválido:" + id);
    }
}