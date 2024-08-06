package com.khackathon.nest.domain.inquiry.service;

import com.khackathon.nest.domain.admin.domain.Admin;
import com.khackathon.nest.domain.inquiry.dto.request.InquiryCreateRequest;
import com.khackathon.nest.domain.inquiry.dto.request.InquiryReplyRequest;
import com.khackathon.nest.domain.inquiry.dto.response.InquiriesResponse;
import com.khackathon.nest.domain.inquiry.dto.response.InquiryResponse;
import com.khackathon.nest.domain.inquiry.entity.Inquiry;
import com.khackathon.nest.domain.inquiry.repository.InquiryRepository;
import com.khackathon.nest.domain.shelter.entity.Shelter;
import com.khackathon.nest.domain.shelter.repository.ShelterRepository;
import com.khackathon.nest.domain.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InquiryService {

    private final InquiryRepository inquiryRepository;
    private final AdminRepository adminRepository;
    private final ShelterRepository shelterRepository;

    @Transactional
    public void create(InquiryCreateRequest request) {
        Shelter shelter = shelterRepository.getReferenceById(request.getShelterId());
        inquiryRepository.save(Inquiry.toEntity(request, shelter));
    }

    @Transactional
    public void updateReply(InquiryReplyRequest request) {
        Inquiry inquiry = inquiryRepository.getReferenceById(request.getInquiryId());
        Admin admin = adminRepository.getReferenceById(request.getAdminId());
        inquiry.updateReply(request, admin);
    }

    public InquiriesResponse getAllBy(Long shelterId) {
        return InquiriesResponse.of(inquiryRepository.findByShelterId(shelterId));
    }

    public InquiryResponse getBy(Long inquiryId) {
        return InquiryResponse.of(inquiryRepository.getReferenceById(inquiryId));
    }
}
