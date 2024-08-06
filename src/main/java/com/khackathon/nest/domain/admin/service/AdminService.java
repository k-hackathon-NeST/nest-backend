package com.khackathon.nest.domain.admin.service;

import com.khackathon.nest.domain.admin.entity.Admin;
import com.khackathon.nest.domain.admin.entity.Region;
import com.khackathon.nest.domain.admin.exception.AdminNotFoundException;
import com.khackathon.nest.domain.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    public void login(String region, String loginId) {
        adminRepository.findByRegionAndLoginId(Region.transRegionByStr(region), loginId)
                .orElseThrow(AdminNotFoundException::new);
    }

    @Transactional
    public void updateFcmToken(Long adminId, String fcmToken) {
        Admin admin = adminRepository.getReferenceById(adminId);
        admin.updateFcmToken(fcmToken);
    }
}
