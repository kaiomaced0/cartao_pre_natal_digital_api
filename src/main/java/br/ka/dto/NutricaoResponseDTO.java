package br.ka.dto;

import br.ka.model.Nutricao;

public record NutricaoResponseDTO(
        long id,
        String titulo,
        String descricao
) {
    public NutricaoResponseDTO(Nutricao n){
        this(n.getId(), n.getTitulo(), n.getDescricao());
    }
}
