package br.ka.dto;

import java.time.LocalDate;

public record UltrassonografiaDTO(
        String observacao,
        String linkArquivo,
        String liq,
        String doppler,
        String placenta,
        String igdum,
        String idadeGestacional,
        LocalDate data

) {
}
