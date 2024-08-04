package com.khackathon.nest.domain.shelter.dto.response;

import com.khackathon.nest.domain.shelter.vo.ShelterInfoMapping;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Schema(description = "예제 응답 response")
public class NearbyResponse {

    private final List<ShelterInfoMapping> shelters;

    public static NearbyResponse of(List<ShelterInfoMapping> shelters) {
        return NearbyResponse.builder()
            .shelters(shelters)
            .build();
    }

}
