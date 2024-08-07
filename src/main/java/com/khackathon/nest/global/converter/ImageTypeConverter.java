package com.khackathon.nest.global.converter;

import com.khackathon.nest.domain.shelter.entity.ImageType;
import com.khackathon.nest.domain.shelter.exception.ImageTypeNotFoundException;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.EnumSet;

@Converter(autoApply = true)
public class ImageTypeConverter implements AttributeConverter<ImageType, String> {

    @Override
    public String convertToDatabaseColumn(ImageType imageType) {
        return imageType.getImageTypeStr();
    }

    @Override
    public ImageType convertToEntityAttribute(String dbData) {
        return EnumSet.allOf(ImageType.class).stream()
            .filter(e -> e.getImageTypeStr().equals(dbData))
            .findAny()
            .orElseThrow(ImageTypeNotFoundException::new);
    }

}
