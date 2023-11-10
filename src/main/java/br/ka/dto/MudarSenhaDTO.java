package br.ka.dto;

public record MudarSenhaDTO(
        String login,
        String senhaAntiga,
        String novaSenha
) {
}
