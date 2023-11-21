package br.ka.dto;

import br.ka.model.Consulta;

import java.time.LocalDate;

public record ConsultaResponseDTO(
        Long idConsulta,
        MedicoResponseDTO medico,
        String tipoConsulta,
        String observacao,
        LocalDate dataRealizada
) {
    public ConsultaResponseDTO(Consulta consulta){
        this(consulta.getId(), new MedicoResponseDTO(consulta.getMedico()), consulta.getTipoConsulta().getLabel(), consulta.getObservacao(),consulta.getDataRealizada());
    }
}
