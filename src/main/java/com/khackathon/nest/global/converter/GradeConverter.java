package com.khackathon.nest.global.converter;

import com.khackathon.nest.domain.inquiry.entity.Grade;
import com.khackathon.nest.domain.inquiry.exception.GradeNotFoundException;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.EnumSet;

@Converter(autoApply = true)
public class GradeConverter implements AttributeConverter<Grade, String> {

    @Override
    public String convertToDatabaseColumn(Grade grade) {
        return grade.getGradeStr();
    }

    @Override
    public Grade convertToEntityAttribute(String dbData) {
        return EnumSet.allOf(Grade.class).stream()
                .filter(e -> e.getGradeStr().equals(dbData))
                .findAny()
                .orElseThrow(GradeNotFoundException::new);
    }
}
