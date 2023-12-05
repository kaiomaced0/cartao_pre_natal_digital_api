package br.ka.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record MamaeDTO(

        String cpf,
        String nome,
        String email,
        @NotBlank
        @Size(min = 3, max = 1000)
        String senha,
        LocalDate dataInicioGestacao
) {

}