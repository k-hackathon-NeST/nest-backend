package com.khackathon.nest.global.converter;

import com.khackathon.nest.domain.admin.entity.Region;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.EnumSet;

@Converter(autoApply = true)
public class RegionConverter implements AttributeConverter<Region, String> {

    @Override
    public String convertToDatabaseColumn(Region region) {
        return region.getRegionStr();
    }

    @Override
    public Region convertToEntityAttribute(String dbData) {
        return EnumSet.allOf(Region.class).stream()
                .filter(e -> e.getRegionStr().equals(dbData))
                .findAny()
                .orElseThrow();
    }
}
