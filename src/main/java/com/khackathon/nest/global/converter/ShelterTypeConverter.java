package com.khackathon.nest.global.converter;

import com.khackathon.nest.domain.shelter.entity.ShelterType;
import com.khackathon.nest.domain.shelter.exception.ShelterTypeNotFoundException;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.EnumSet;

@Converter(autoApply = true)
public class ShelterTypeConverter implements AttributeConverter<ShelterType, String> {

    @Override
    public String convertToDatabaseColumn(ShelterType shelterType) {
        return shelterType.getShelterTypeStr();
    }

    @Override
    public ShelterType convertToEntityAttribute(String dbData) {
        return EnumSet.allOf(ShelterType.class).stream()
            .filter(e -> e.getShelterTypeStr().equals(dbData))
            .findAny()
            .orElseThrow(ShelterTypeNotFoundException::new);
    }
}
