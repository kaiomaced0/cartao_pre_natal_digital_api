package br.ka.dto;

import br.ka.model.Perfil;
import br.ka.model.Usuario;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record UsuarioResponseDTO(
        Long id, String nome, String email, String cpf, List<String> perfis
) {
    public UsuarioResponseDTO(Usuario user) {
        this(user.getId(),
                user.getNome(),
                user.getEmail(),
                user.getCpf(),
                user.getPerfis().stream().map(perfil -> perfil.getLabel()).collect(Collectors.toList()));

    }
}
