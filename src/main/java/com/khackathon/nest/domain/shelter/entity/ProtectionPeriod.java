package com.khackathon.nest.domain.shelter.entity;

import com.khackathon.nest.domain.shelter.exception.ProtectionPeriodNotFoundException;
import java.util.EnumSet;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProtectionPeriod {

    TEMPORARY("일시"),
    SHORT_TERM("단기"),
    MID_TO_LONG_TERM("중장기");

    private final String protectionPeriodStr;

    public static ProtectionPeriod transProtectionPeriodByStr(String protectionPeriodStr) {
        return EnumSet.allOf(ProtectionPeriod.class).stream()
            .filter(e -> e.getProtectionPeriodStr().equals(protectionPeriodStr))
            .findAny()
            .orElseThrow(ProtectionPeriodNotFoundException::new);
    }

}
