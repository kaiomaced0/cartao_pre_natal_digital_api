package br.ka.dto;

import br.ka.model.Ultrassonografia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record UltrassonografiaResponseDTO(
        Long id,
        String observacao,
        String linkArquivo,
        String idadeGestacional,
        String liq,
        String doppler,
        String placenta,
        String igdum,
        String data

) {
    public UltrassonografiaResponseDTO(Ultrassonografia u){

        this(u.getId(), u.getObservacao(), u.getLinkArquivo(), u.getIdadeGestacional(), u.getLiq(), u.getDoppler(), u.getPlacenta(), u.getIgdum(), u.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
