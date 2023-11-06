package br.ka.dto;

import br.ka.model.Exame;

public record ExameResponseDTO(
        Long idExame, String tipoExame, String localExameRealizado, String observacao
) {
    public ExameResponseDTO(Exame exame){
        this(exame.getId(), exame.getTipoExame(), exame.getLocalExameRealizado(), exame.getObservacao());
    }
}
