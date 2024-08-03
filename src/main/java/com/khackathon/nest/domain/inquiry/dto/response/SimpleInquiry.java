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
public class SimpleInquiry {
    @Schema(description = "문의 글 id(pk)")
    private final Long inquiryId;
    private final String name;
    private final String content;
    private final LocalDateTime askAt;
    private final Boolean isAnswer;

    public static SimpleInquiry of(Inquiry inquiry) {
        return SimpleInquiry.builder()
                .inquiryId(inquiry.getId())
                .name(inquiry.getName())
                .content(inquiry.getContent())
                .askAt(inquiry.getAskAt())
                .isAnswer(inquiry.getIsAnswer())
                .build();
    }
}
