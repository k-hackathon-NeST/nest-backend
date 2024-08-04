package com.khackathon.nest.domain.shelter.service;

import com.khackathon.nest.domain.shelter.dto.response.NearbyResponse;
import com.khackathon.nest.domain.shelter.dto.response.ShelterResponse;
import com.khackathon.nest.domain.shelter.exception.ShelterNotFoundException;
import com.khackathon.nest.domain.shelter.repository.ShelterRepository;
import com.khackathon.nest.domain.shelter.service.util.PointUtils;
import com.khackathon.nest.domain.shelter.vo.ShelterSimpleInfoMapping;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.locationtech.jts.geom.Point;

@Service
@RequiredArgsConstructor
public class ShelterService {

    private final ShelterRepository shelterRepository;

    public NearbyResponse findNearbyBy(
        Double longitude,
        Double latitude
    ) {
        Point point = PointUtils.getPoint(
            longitude,
            latitude
        );

        List<ShelterSimpleInfoMapping> shelters = shelterRepository.findNearbyBy(point);

        return NearbyResponse.of(shelters);
    }

    public ShelterResponse getBy(Long shelterId) {
        return ShelterResponse.of(shelterRepository.getBy(shelterId)
            .orElseThrow(ShelterNotFoundException::new)
        );
    }
}
