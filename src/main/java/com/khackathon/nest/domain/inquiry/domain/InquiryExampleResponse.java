package com.khackathon.nest.domain.inquiry.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Schema(description = "예제 응답 response")
public class InquiryExampleResponse {
    @Schema(description = "예제 응답 필드", defaultValue = "content")
    private final String content;

    public static InquiryExampleResponse of(Inquiry inquiry) {
        return InquiryExampleResponse.builder()
                .content(inquiry.getContent())
                .build();
    }
}
