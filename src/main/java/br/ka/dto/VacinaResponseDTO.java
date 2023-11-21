package br.ka.dto;

import br.ka.model.Vacina;

import java.time.LocalDate;

public record VacinaResponseDTO(
        Long id, String nome, Double quantidadeDoses, Double doseAtual, String nomeProfissionalRealizouVacina, String localRealizado, String loteVacina, LocalDate dataRealizada
) {
    public VacinaResponseDTO(Vacina vacina){
        this(vacina.getId(), vacina.getNome(),vacina.getQuantidadeDoses(), vacina.getDoseAtual(), vacina.getNomeProfissionalRealizouVacina(), vacina.getLocalVacinaRealizada(), vacina.getLoteVacina(), vacina.getDataRealizada());
    }
}
