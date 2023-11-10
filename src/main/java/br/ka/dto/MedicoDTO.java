package br.ka.dto;

import java.util.List;

public record MedicoDTO(
        UsuarioDTO usuarioDTO,
        Long idEspecializacao,
        String crm

) {
}
