package br.ka.dto;

import br.ka.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioDTO(
        @NotBlank
        @Size(min = 3, max = 25)
        String cpf,
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Size(min = 3, max = 1000)
        String senha
) {

}