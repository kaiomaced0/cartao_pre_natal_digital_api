package br.ka.dto;

import br.ka.model.Consulta;

import java.time.LocalDate;

public record ConsultaResponseDTO(
        Long id,
        MedicoResponseDTO medico,
        String observacao,
        String titulo,
        String idadeGestacional,
        LocalDate dataRealizada,
        Long peso,
        String mf,
        String edema
) {
    public ConsultaResponseDTO(Consulta consulta){
        this(consulta.getId(), new MedicoResponseDTO(consulta.getMedico()), consulta.getObservacao(),consulta.getTitulo(), consulta.getIdadeGestacional(), consulta.getDataRealizada(), consulta.getPeso(), consulta.getMf(), consulta.getEdema());
    }
}
