package br.ka.converter;

import br.ka.model.TipoConsulta;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoConsultaConverter implements AttributeConverter<TipoConsulta, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TipoConsulta tipoConsulta) {
        return tipoConsulta == null ? null : tipoConsulta.getId();
    }

    @Override
    public TipoConsulta convertToEntityAttribute(Integer id) {
        return TipoConsulta.valueOf(id);
    }
}