package com.khackathon.nest.domain.inquiry.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Schema(description = "문의 글 답변 request")
public class InquiryReplyRequest {

    @NotNull
    @Schema(description = "관계자 id(pk)")
    private final Long adminId;

    @NotNull
    @Schema(description = "문의 글 id(pk)")
    private final Long inquiryId;

    @NotBlank
    private final String answer;
}
