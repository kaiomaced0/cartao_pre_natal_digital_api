package br.ka.dto;

import br.ka.model.Gestacao;

import java.time.LocalDate;

public record GestacaoResponseDTO(
        Long id,
        String nomeBebe,
        String idadeGestacional,
        LocalDate dataInicio,
        Boolean vacinaDtpa,
        String observacaoFinal
) {
    public GestacaoResponseDTO (Gestacao gestacao){
        this(gestacao.getId(), gestacao.getNomeBebe(), gestacao.getIdadeGestacional(), gestacao.getDataInicio(), gestacao.getVacinaDTPa() != null, gestacao.getObservacaoFinal());
    }
}
