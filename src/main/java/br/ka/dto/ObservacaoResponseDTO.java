package br.ka.dto;

import br.ka.model.Observacao;

public record ObservacaoResponseDTO(
        Long id, String observacao, String resposta, Boolean atendido
) {
    public ObservacaoResponseDTO(Observacao o){
        this(o.getId(), o.getObservacao(), o.getResposta(), o.getAtendido());
    }
}
