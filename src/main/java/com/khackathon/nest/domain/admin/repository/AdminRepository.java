package com.khackathon.nest.domain.admin.repository;


import com.khackathon.nest.domain.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
