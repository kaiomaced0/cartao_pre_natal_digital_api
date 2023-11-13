package br.ka.dto;

import br.ka.model.Medico;
import br.ka.model.Perfil;

import java.util.List;
import java.util.stream.Collectors;

public record MedicoResponseDTO(
        Long id, String nome, String telefone, String email, String cpf, List<Perfil> perfis, String crm
) {
    public MedicoResponseDTO(Medico user) {
        this(user.getId(),
                user.getNome(),
                user.getTelefone(),
                user.getEmail(),
                user.getCpf(),
                user.getPerfis().stream().collect(Collectors.toList()), user.getCrm());

    }
}
