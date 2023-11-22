package br.ka.dto;

import br.ka.model.Vacina;

public record VacinaDTO(

        String nome, Double quantidadeDoses, Double doseAtual, String nomeProfissionalRealizouVacina, String localRealizado, String loteVacina
) {
    public Vacina criaVacina(VacinaDTO dto){
        Vacina v = new Vacina();
        v.setNome(dto.nome());
        v.setQuantidadeDoses(dto.quantidadeDoses());
        v.setDoseAtual(dto.doseAtual());
        v.setNomeProfissionalRealizouVacina(dto.nomeProfissionalRealizouVacina());
        v.setLocalVacinaRealizada(dto.localRealizado());
        v.setLoteVacina(dto.loteVacina());
        return v;
    }
}
