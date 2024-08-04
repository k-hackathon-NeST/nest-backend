package com.khackathon.nest.domain.shelter.dto.response;

import com.khackathon.nest.domain.shelter.vo.ShelterSimpleInfoMapping;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class NearbyResponse {

    private final List<ShelterSimpleInfoMapping> shelters;

    public static NearbyResponse of(List<ShelterSimpleInfoMapping> shelters) {
        return NearbyResponse.builder()
            .shelters(shelters)
            .build();
    }

}
