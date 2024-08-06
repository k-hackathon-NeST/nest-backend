package com.khackathon.nest.domain.admin.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Region {

    SEOUL("서울특별시"),
    BUSAN("부산광역시");

    private final String regionStr;
}
