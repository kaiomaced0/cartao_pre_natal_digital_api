package br.ka.dto;

import br.ka.model.Ultrassonografia;

public record UltrassonografiaResponseDTO(
        Long id,
        String observacao,
        String linkArquivo,
        String idadeGestacional

) {
    public UltrassonografiaResponseDTO(Ultrassonografia u){
        this(u.getId(), u.getObservacao(), u.getLinkArquivo(), u.getIdadeGestacional());
    }
}
