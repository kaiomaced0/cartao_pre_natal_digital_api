package br.ka.converter;

import br.ka.model.Especializacao;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EspecializacaoConverter implements AttributeConverter<Especializacao, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Especializacao especializacao) {
        return especializacao == null ? null : especializacao.getId();
    }

    @Override
    public Especializacao convertToEntityAttribute(Integer id) {
        return Especializacao.valueOf(id);
    }
}