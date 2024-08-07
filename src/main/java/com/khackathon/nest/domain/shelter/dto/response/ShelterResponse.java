package com.khackathon.nest.domain.shelter.dto.response;

import com.khackathon.nest.domain.shelter.vo.ShelterImageMapping;
import com.khackathon.nest.domain.shelter.vo.ShelterInfoMapping;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ShelterResponse {

    private final ShelterInfoMapping shelterInfoMapping;
    private final List<ShelterImageMapping> shelterImageMappings;

    public static ShelterResponse of(
        ShelterInfoMapping shelterInfoMapping,
        List<ShelterImageMapping> shelterImageMappings
    ) {
        return ShelterResponse.builder()
            .shelterInfoMapping(shelterInfoMapping)
            .shelterImageMappings(shelterImageMappings)
            .build();
    }

}
