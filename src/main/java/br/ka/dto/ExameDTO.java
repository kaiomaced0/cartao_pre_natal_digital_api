package br.ka.dto;

import br.ka.model.Exame;

public record ExameDTO(
        Long idMamae,
        String tipoExame,
        String localExameRealizado,
        String observacao
) {
    public static Exame criaExame(ExameDTO exame){
        Exame e = new Exame();
        e.setTipoExame(exame.tipoExame());
        e.setLocalExameRealizado(exame.localExameRealizado);
        e.setObservacao(exame.observacao());
        return e;
    }
}
