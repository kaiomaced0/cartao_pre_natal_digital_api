package br.ka.dto;

import br.ka.model.Mamae;

public record MamaeResponseDTO(
        Long idMamae,
        UsuarioResponseDTO usuarioResponseDTO,
        Boolean emGestacao,
        String convenio

) {
    public MamaeResponseDTO(Mamae user) {
    this(user.getId(), new UsuarioResponseDTO(user), user.getEmGestacao(), user.getConvenio());
}
}
