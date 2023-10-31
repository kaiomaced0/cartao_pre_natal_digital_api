package br.ka.dto;

import br.ka.model.Acompanhamento;

public record ConsultaDTO(
        Long idUsuario,
        Long idTipoConsulta,
        Long idMedico,
        String observacao

) {

}
