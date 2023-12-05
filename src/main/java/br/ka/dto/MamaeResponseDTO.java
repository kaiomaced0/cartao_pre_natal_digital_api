package br.ka.dto;

import br.ka.model.Mamae;
import br.ka.model.Perfil;

import java.util.List;

public record MamaeResponseDTO(
        Long idMamae,
        String nome,
        String email,
        String cpf,
        List<String> perfis,
        Boolean emGestacao,
        String idadeGestacional,
        String convenio,
        String contatoEmergencia,
        String nomeBebe,
        String dadosMedico

) {
    public MamaeResponseDTO(Mamae user) {
    this(user.getId(),
            user.getNome(), user.getEmail(), user.getCpf(), user.getPerfis().stream().map(perfil -> perfil.getLabel()).toList(), user.getEmGestacao(),user.getGestacao().getIdadeGestacional(), user.getConvenio(), user.getContatoEmergencia(), user.getGestacao().getNomeBebe(), user.getMedico().getNome() + " - " + user.getMedico().getTelefone());
}
}
