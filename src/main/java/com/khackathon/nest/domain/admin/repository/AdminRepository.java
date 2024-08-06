package com.khackathon.nest.domain.admin.repository;


import com.khackathon.nest.domain.admin.entity.Admin;
import com.khackathon.nest.domain.admin.entity.Region;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByRegionAndLoginId(Region region, String loginId);

    List<Admin> findByShelterId(Long shelterId);
}
