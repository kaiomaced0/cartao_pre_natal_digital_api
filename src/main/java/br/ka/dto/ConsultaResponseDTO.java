package br.ka.dto;

import br.ka.model.Consulta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record ConsultaResponseDTO(
        Long id,
        MedicoResponseDTO medico,
        String observacao,
        String titulo,
        String idadeGestacional,
        String dataRealizada,
        Long peso,
        String mf,
        String edema
) {
    public ConsultaResponseDTO(Consulta consulta){
        this(consulta.getId(), new MedicoResponseDTO(consulta.getMedico()), consulta.getObservacao(),consulta.getTitulo(), consulta.getIdadeGestacional(), consulta.getDataRealizada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), consulta.getPeso(), consulta.getMf(), consulta.getEdema());
    }
}
