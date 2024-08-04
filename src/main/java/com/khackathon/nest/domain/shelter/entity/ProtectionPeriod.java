package com.khackathon.nest.domain.shelter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProtectionPeriod {

    TEMPORARY("임시"),
    SHORT_TERM("단기"),
    MID_TO_LONG_TERM("중장기");

    private final String protectionPeriodStr;

}
