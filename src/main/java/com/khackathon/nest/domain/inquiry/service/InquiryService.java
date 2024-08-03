package com.khackathon.nest.domain.inquiry.service;

import com.khackathon.nest.domain.inquiry.dto.InquiryCreateRequest;
import com.khackathon.nest.domain.inquiry.entity.Inquiry;
import com.khackathon.nest.domain.inquiry.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InquiryService {

    private final InquiryRepository inquiryRepository;

    @Transactional
    public void create(InquiryCreateRequest request) {
        inquiryRepository.save(Inquiry.toEntity(request));
    }
}
