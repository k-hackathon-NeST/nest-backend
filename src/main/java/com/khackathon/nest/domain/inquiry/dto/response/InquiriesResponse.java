package com.khackathon.nest.domain.inquiry.dto.response;

import com.khackathon.nest.domain.inquiry.entity.Inquiry;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class InquiriesResponse {
    private final List<SimpleInquiry> simpleInquiryList;

    public static InquiriesResponse of(List<Inquiry> inquiries) {
        return InquiriesResponse.builder()
                .simpleInquiryList(inquiries.stream()
                        .map(inquiry -> SimpleInquiry.of(inquiry))
                        .toList())
                .build();
    }
}
