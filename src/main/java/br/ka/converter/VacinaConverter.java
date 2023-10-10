package br.ka.converter;
import br.ka.model.Vacina;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class VacinaConverter implements AttributeConverter<Vacina, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Vacina vacina) {
        return vacina == null ? null : vacina.getId();
    }

    @Override
    public Vacina convertToEntityAttribute(Integer id) {
        return Vacina.valueOf(id);
    }
}