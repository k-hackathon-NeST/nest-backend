package com.khackathon.nest.domain.inquiry.repository;

import com.khackathon.nest.domain.inquiry.entity.Inquiry;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long>{
    List<Inquiry> findByShelterId(Long shelterId);
}
