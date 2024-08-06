package com.khackathon.nest.domain.admin.entity;

import com.khackathon.nest.domain.admin.exception.RegionNotFoundException;
import java.util.EnumSet;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Region {

    SEOUL("서울특별시"),
    BUSAN("부산광역시"),
    DAEGU("대구광역시"),
    INCHEON("인천광역시"),
    DAEJEON("대전광역시");

    private final String regionStr;

    public static Region transRegionByStr(String regionStr) {
        return EnumSet.allOf(Region.class).stream()
                .filter(e -> e.getRegionStr().equals(regionStr))
                .findAny()
                .orElseThrow(RegionNotFoundException::new);
    }
}
