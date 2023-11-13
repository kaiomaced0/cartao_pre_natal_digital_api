package br.ka.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record MedicoDTO(
        String cpf,
        String nome,
        String telefone,
        String email,
        @NotBlank
        @Size(min = 3, max = 1000)
        String senha,
        Long idEspecializacao,
        String crm

) {
}
