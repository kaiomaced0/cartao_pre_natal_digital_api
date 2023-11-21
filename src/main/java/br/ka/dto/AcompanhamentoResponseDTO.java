package br.ka.dto;

import br.ka.model.Acompanhamento;

import java.time.LocalDate;

public record AcompanhamentoResponseDTO(
        Long id,
        String observacao,
        String dados,
        Double peso,
        LocalDate dataRealizada,
        String idadeGestacional
) {
    public AcompanhamentoResponseDTO(Acompanhamento acompanhamento){
        this(acompanhamento.getId(), acompanhamento.getObservacao(), acompanhamento.getDados(), acompanhamento.getPeso(), acompanhamento.getDataRealizada(), acompanhamento.getIdadeGestacional());
    }
}
