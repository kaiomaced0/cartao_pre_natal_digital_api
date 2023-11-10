package br.ka.dto;

import br.ka.model.Acompanhamento;

public record AcompanhamentoDTO(
        Long idMamae,
        String observacao,
        String dados,
        Double peso
) {
    public static Acompanhamento geraAcompanhamento(AcompanhamentoDTO dto){
        Acompanhamento a = new Acompanhamento();
        a.setObservacao(dto.observacao());
        a.setDados(dto.dados());
        a.setPeso(dto.peso());
        return a;
    }
}
