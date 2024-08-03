package com.khackathon.nest.domain.inquiry.dto.response;

import com.khackathon.nest.domain.inquiry.entity.Inquiry;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
public class SimpleInquiry {
    private final String name;
    private final String content;
    private final LocalDateTime askAt;
    private final Boolean isAnswer;

    public static SimpleInquiry of(Inquiry inquiry) {
        return SimpleInquiry.builder()
                .name(inquiry.getName())
                .content(inquiry.getContent())
                .askAt(inquiry.getAskAt())
                .isAnswer(inquiry.getIsAnswer())
                .build();
    }
}
