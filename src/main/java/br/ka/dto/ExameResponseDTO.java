package br.ka.dto;

import br.ka.model.Exame;

import java.time.LocalDate;

public record ExameResponseDTO(
        Long id, String tipoExame, String localExameRealizado, String observacao, LocalDate dataRealizada
) {
    public ExameResponseDTO(Exame exame){
        this(exame.getId(), exame.getTipoExame(), exame.getLocalExameRealizado(), exame.getObservacao(), exame.getDataRealizada());
    }
}
