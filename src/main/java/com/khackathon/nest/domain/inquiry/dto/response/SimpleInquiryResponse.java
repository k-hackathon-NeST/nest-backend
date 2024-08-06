package com.khackathon.nest.domain.inquiry.dto.response;

import com.khackathon.nest.domain.inquiry.entity.Inquiry;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
public class SimpleInquiryResponse {
    @Schema(description = "문의 글 id(pk)")
    private final Long inquiryId;
    private final String name;
    private final String title;
    private final LocalDateTime askAt;
    private final Boolean isAnswer;

    public static SimpleInquiryResponse of(Inquiry inquiry) {
        return SimpleInquiryResponse.builder()
                .inquiryId(inquiry.getId())
                .name(inquiry.getName())
                .title(inquiry.getTitle())
                .askAt(inquiry.getAskAt())
                .isAnswer(inquiry.getIsAnswer())
                .build();
    }
}
