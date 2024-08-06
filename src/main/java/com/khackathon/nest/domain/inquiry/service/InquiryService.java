package com.khackathon.nest.domain.inquiry.service;

import com.khackathon.nest.domain.admin.entity.Admin;
import com.khackathon.nest.domain.inquiry.dto.request.InquiryCreateRequest;
import com.khackathon.nest.domain.inquiry.dto.request.InquiryReplyRequest;
import com.khackathon.nest.domain.inquiry.dto.response.InquiryResponse;
import com.khackathon.nest.domain.inquiry.dto.response.SimpleInquiryResponse;
import com.khackathon.nest.domain.inquiry.entity.Inquiry;
import com.khackathon.nest.domain.inquiry.repository.InquiryRepository;
import com.khackathon.nest.domain.notification.NotificationService;
import com.khackathon.nest.domain.shelter.entity.Shelter;
import com.khackathon.nest.domain.shelter.repository.ShelterRepository;
import com.khackathon.nest.domain.admin.repository.AdminRepository;
import com.khackathon.nest.infra.nurigo.NurigoService;
import java.util.List;
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
    private final NurigoService nurigoService;
    private final NotificationService notificationService;

    @Transactional
    public void create(InquiryCreateRequest request) {
        Shelter shelter = shelterRepository.getReferenceById(request.getShelterId());
        Inquiry inquiry = inquiryRepository.save(Inquiry.toEntity(request, shelter));
        notificationService.sendToAdmins(shelter, inquiry);
    }

    @Transactional
    public void updateReply(InquiryReplyRequest request) {
        Inquiry inquiry = inquiryRepository.getReferenceById(request.getInquiryId());
        Admin admin = adminRepository.getReferenceById(request.getAdminId());
        inquiry.updateReply(request, admin);
        nurigoService.sendMessage(inquiry);
    }

    public List<InquiryResponse> getBy(String phoneNumber, String password) {
        return inquiryRepository.findByPhoneNumberAndPassword(phoneNumber, password).stream()
                .map(InquiryResponse::of)
                .toList();
    }

    public List<SimpleInquiryResponse> getSimpleBy(Long adminId) {
        Admin admin = adminRepository.getReferenceById(adminId);
        Long shelterId = admin.getShelter().getId();
        return inquiryRepository.findByShelterId(shelterId).stream()
                .map(SimpleInquiryResponse::of)
                .toList();
    }

    public InquiryResponse getBy(Long inquiryId) {
        return InquiryResponse.of(inquiryRepository.getReferenceById(inquiryId));
    }
}
