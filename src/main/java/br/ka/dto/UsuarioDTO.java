package br.ka.dto;

import br.ka.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioDTO(
        @NotBlank
        @Size(min = 3, max = 25)
        String cpf,
        @NotBlank
        @Size(min = 3, max = 1000)
        String senha,
        @NotBlank
        @Email
        String email
) {
    public static Usuario criaUsuario(UsuarioDTO usuarioDTO){
        Usuario user = new Usuario();
        user.setCpf(usuarioDTO.cpf);
        user.setEmail(usuarioDTO.email);
        user.setSenha(usuarioDTO.senha);
        return user;
    }
}