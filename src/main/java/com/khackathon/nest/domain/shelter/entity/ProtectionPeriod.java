package com.khackathon.nest.domain.shelter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProtectionPeriod {

    TEMPORARY("임시"),
    SHORTTERM("단기"),
    MIDTOLONGTERM("중장기");

    private final String protectionPeriodStr;

}
