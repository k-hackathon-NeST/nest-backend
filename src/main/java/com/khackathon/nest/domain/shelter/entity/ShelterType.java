package com.khackathon.nest.domain.shelter.entity;

import com.khackathon.nest.domain.shelter.exception.ShelterTypeNotFoundException;
import java.util.EnumSet;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ShelterType {

    FEMALE_ONLY("여자 청소년만 입소 가능"),
    MALE_ONLY("남자 청소년만 입소 가능"),
    ALL("모든 청소년 입소 가능");

    private final String shelterTypeStr;

    public static ShelterType transShelterByStr(String shelterTypeStr) {
        return EnumSet.allOf(ShelterType.class).stream()
            .filter(e -> e.getShelterTypeStr().equals(shelterTypeStr))
            .findAny()
            .orElseThrow(ShelterTypeNotFoundException::new);
    }

}
