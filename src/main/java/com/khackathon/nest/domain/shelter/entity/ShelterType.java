package com.khackathon.nest.domain.shelter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ShelterType {

    FEMALE_ONLY("여자 청소년만 숙박 가능"),
    MALE_ONLY("남자 청소년만 숙박 가능"),
    ALL("모든 청소년 숙박 가능");

    private final String shelterTypeStr;

}
