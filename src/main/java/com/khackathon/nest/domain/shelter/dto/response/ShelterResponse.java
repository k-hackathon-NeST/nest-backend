package com.khackathon.nest.domain.shelter.dto.response;

import com.khackathon.nest.domain.shelter.vo.ShelterInfoMapping;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ShelterResponse {

    private final ShelterInfoMapping shelterInfoMapping;

    public static ShelterResponse of(ShelterInfoMapping shelterInfoMapping) {
        return ShelterResponse.builder()
            .shelterInfoMapping(shelterInfoMapping)
            .build();
    }

}
