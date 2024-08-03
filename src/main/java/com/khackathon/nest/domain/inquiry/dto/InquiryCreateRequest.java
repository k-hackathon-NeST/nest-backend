package com.khackathon.nest.domain.inquiry.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Schema(description = "문의 글 작성 request")
public class InquiryCreateRequest {

    @NotNull
    private final Long shelterId;

    @NotBlank
    private final String name;

    @NotBlank
    @Schema(description = "전화번호. '010XXXXXXXX'의 형태로 요청해주세요.", defaultValue = "01023679323")
    private final String phoneNumber;

    @NotNull
    @Schema(description = "생년월일. 'yyyy-mm-dd'의 형태로 요청해주세요.", defaultValue = "1999-03-23")
    private final LocalDate birthDate;

    @NotBlank
    @Schema(description = "학년. '중학생', '고등학생', '대학생', '성인' 중 하나로 요청해주세요.", defaultValue = "중학생")
    private final String grade;

    @NotNull
    @Schema(description = "희망 입소 날짜. 'yyyy-mm-dd'의 형태로 요청해주세요.", defaultValue = "2024-08-02")
    private final LocalDate admissionDate;

    @NotNull
    @Schema(description = "희망 퇴소 날짜. 'yyyy-mm-dd'의 형태로 요청해주세요.", defaultValue = "2024-08-08")
    private final LocalDate dischargeDate;

    @NotBlank
    private final String title;

    @NotBlank
    private final String content;

    @NotBlank
    private final String password;


}
