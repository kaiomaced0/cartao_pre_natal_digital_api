package br.ka.dto;

import br.ka.model.Acompanhamento;

public record ConsultaDTO(
        Long idTipoConsulta,
        Long idMedico,
        String observacao

) {

}
