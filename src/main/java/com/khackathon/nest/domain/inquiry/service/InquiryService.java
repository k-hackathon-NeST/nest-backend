package com.khackathon.nest.domain.inquiry.service;

import com.khackathon.nest.domain.inquiry.dto.InquiryCreateRequest;
import com.khackathon.nest.domain.inquiry.dto.InquiryReplyRequest;
import com.khackathon.nest.domain.inquiry.entity.Inquiry;
import com.khackathon.nest.domain.inquiry.repository.InquiryRepository;
import com.khackathon.nest.domain.shelter.domain.Shelter;
import com.khackathon.nest.domain.shelter.repository.ShelterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InquiryService {

    private final InquiryRepository inquiryRepository;
    private final ShelterRepository shelterRepository;

    @Transactional
    public void create(InquiryCreateRequest request) {
        Shelter shelter = shelterRepository.getReferenceById(request.getShelterId());
        inquiryRepository.save(Inquiry.toEntity(request, shelter));
    }
}
