package com.khackathon.nest.domain.shelter.service;

import com.khackathon.nest.domain.shelter.dto.response.NearbyResponse;
import com.khackathon.nest.domain.shelter.repository.ShelterRepository;
import com.khackathon.nest.domain.shelter.service.util.PointUtils;
import com.khackathon.nest.domain.shelter.vo.ShelterInfoMapping;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.locationtech.jts.geom.Point;

@Service
@RequiredArgsConstructor
public class ShelterService {

    private final ShelterRepository shelterRepository;

    public NearbyResponse getNearby(
        Double longitude,
        Double latitude
    ) {
        Point point = PointUtils.getPoint(
            longitude,
            latitude
        );

        List<ShelterInfoMapping> shelters = shelterRepository.getNearby(point);

        return NearbyResponse.of(shelters);
    }
}
