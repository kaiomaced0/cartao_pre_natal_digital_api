package br.ka.dto;

import br.ka.model.Vacina;

public record VacinaResponseDTO(
        Long id, String nome, Double quantidadeDoses, Double doseAtual, String nomeProfissionalRealizouVacina, String localRealizado, String loteVacina
) {
    public VacinaResponseDTO(Vacina vacina){
        this(vacina.getId(), vacina.getNome(),vacina.getQuantidadeDoses(), vacina.getDoseAtual(), vacina.getNomeProfissionalRealizouVacina(), vacina.getLocalVacinaRealizada(), vacina.getLoteVacina());
    }
}
