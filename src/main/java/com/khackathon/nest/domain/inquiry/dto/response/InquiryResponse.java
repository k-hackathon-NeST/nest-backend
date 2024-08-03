package com.khackathon.nest.domain.inquiry.dto.response;

import com.khackathon.nest.domain.inquiry.entity.Inquiry;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class InquiryResponse {
    @Schema(description = "문의자 이름")
    private final String inquirerName;
    private final String phoneNumber;
    private final String grade;
    private final LocalDate admissionDate;
    private final LocalDate dischargeDate;
    private final String title;
    private final String content;
    @Schema(description = "답변이 없는 경우 null로 응답합니다.")
    private final String answer;
    @Schema(description = "관계자 이름, 답변이 없는 경우 null로 응답합니다.")
    private final String adminName;

    public static InquiryResponse of(Inquiry inquiry) {
        InquiryResponse.InquiryResponseBuilder builder = InquiryResponse.builder()
                .inquirerName(inquiry.getName())
                .phoneNumber(inquiry.getPhoneNumber())
                .grade(inquiry.getGrade())
                .admissionDate(inquiry.getAdmissionDate())
                .dischargeDate(inquiry.getDischargeDate())
                .title(inquiry.getTitle())
                .content(inquiry.getContent());

        if(inquiry.getIsAnswer()) {
            builder.answer(inquiry.getAnswer());
            builder.adminName(inquiry.getAdmin().getName());
        }
        return builder.build();
    }
}
