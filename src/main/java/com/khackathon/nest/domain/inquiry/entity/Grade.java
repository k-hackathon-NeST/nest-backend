package com.khackathon.nest.domain.inquiry.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Grade {

    ELEMENTARY("초등학생"),
    MIDDLE("중학생"),
    HIGH("고등학생"),
    ADULT("대학생");

    private final String gradeStr;
}
