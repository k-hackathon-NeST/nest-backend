package com.khackathon.nest.domain.admin.repository;


import com.khackathon.nest.domain.admin.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
