package com.khackathon.nest.global.converter;

import com.khackathon.nest.domain.shelter.entity.ProtectionPeriod;
import com.khackathon.nest.domain.shelter.exception.ProtectionPeriodNotFoundException;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.EnumSet;

@Converter(autoApply = true)
public class ProtectionPeriodConverter implements AttributeConverter<ProtectionPeriod, String> {

    @Override
    public String convertToDatabaseColumn(ProtectionPeriod protectionPeriod) {
        return protectionPeriod.getProtectionPeriodStr();
    }

    @Override
    public ProtectionPeriod convertToEntityAttribute(String dbData) {
        return EnumSet.allOf(ProtectionPeriod.class).stream()
            .filter(e -> e.getProtectionPeriodStr().equals(dbData))
            .findAny()
            .orElseThrow(ProtectionPeriodNotFoundException::new);
    }
}
