package com.khackathon.nest.domain.inquiry.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Schema(description = "문의 글 작성 request")
public class InquiryCreateRequest {
    @NotBlank
    @Schema(description = "전화 번호, 문자 전송 시 해당 번호 사용")
    private final String phoneNumber;
    @NotBlank
    @Schema(description = "작성 글 내용")
    private final String content;
    // ...
}
