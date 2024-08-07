package com.khackathon.nest.domain.shelter.service;

import com.khackathon.nest.domain.admin.entity.Admin;
import com.khackathon.nest.domain.admin.repository.AdminRepository;
import com.khackathon.nest.domain.shelter.dto.request.ShelterUpdateRequest;
import com.khackathon.nest.domain.shelter.dto.response.NearbyResponse;
import com.khackathon.nest.domain.shelter.dto.response.ShelterResponse;
import com.khackathon.nest.domain.shelter.entity.ProtectionPeriod;
import com.khackathon.nest.domain.shelter.entity.Shelter;
import com.khackathon.nest.domain.shelter.entity.ShelterType;
import com.khackathon.nest.domain.shelter.exception.ShelterNotFoundException;
import com.khackathon.nest.domain.shelter.repository.ShelterImageRepository;
import com.khackathon.nest.domain.shelter.repository.ShelterRepository;
import com.khackathon.nest.domain.shelter.service.util.PointUtils;
import com.khackathon.nest.domain.shelter.vo.ShelterSimpleInfoMapping;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.locationtech.jts.geom.Point;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ShelterService {

    private final ShelterRepository shelterRepository;
    private final ShelterImageRepository shelterImageRepository;
    private final AdminRepository adminRepository;

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
        return getByShelterId(shelterId);
    }

    public ShelterResponse getByAdminId(Long adminId){
        Admin admin = adminRepository.getReferenceById(adminId);

        return getByShelterId(admin.getShelter().getId());
    }

    private ShelterResponse getByShelterId(Long shelterId){
        Shelter shelter = shelterRepository.getReferenceById(shelterId);

        return ShelterResponse.of(shelterRepository.getBy(shelterId)
            .orElseThrow(ShelterNotFoundException::new),
            shelterImageRepository.findByShelter(shelter)
        );
    }

    @Transactional
    public void transInfo(ShelterUpdateRequest request) {
        Admin admin = adminRepository.getReferenceById(request.getAdminId());

        if(!Objects.equals(admin.getShelter().getId(), request.getShelterId())) throw new ShelterNotFoundException();

        Shelter shelter = shelterRepository.getReferenceById(request.getShelterId());
        shelter.transInfo(
            request.getName(),
            request.getDescription(),
            request.getCapacity(),
            request.getCurrentResident(),
            request.getPhoneNumber(),
            request.getOperationHour(),
            ProtectionPeriod.transProtectionPeriodByStr(request.getProtectionPeriod()),
            ShelterType.transShelterByStr(request.getShelterType())
        );
    }

}
