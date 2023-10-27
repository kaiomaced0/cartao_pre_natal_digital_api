package br.ka.converter;

import br.ka.model.TipoVacina;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoVacinaConverter implements AttributeConverter<TipoVacina, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TipoVacina tipoVacina) {
        return tipoVacina == null ? null : tipoVacina.getId();
    }

    @Override
    public TipoVacina convertToEntityAttribute(Integer id) {
        return TipoVacina.valueOf(id);
    }
}