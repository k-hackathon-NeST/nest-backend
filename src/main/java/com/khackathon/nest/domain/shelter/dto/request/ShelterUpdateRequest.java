package com.khackathon.nest.domain.shelter.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Schema(description = "쉼터 정보 수정 request")
public class ShelterUpdateRequest {

    @NotNull
    private final Long adminId;

    @NotNull
    private final Long shelterId;

    @NotBlank
    private final String name;

    @NotBlank
    private final String description;

    @NotNull
    @Schema(description = "최대 수용 인원")
    private final int capacity;

    @NotNull
    @Schema(description = "현재 입소 인원")
    private final int currentResident;

    @NotBlank
    private final String phoneNumber;

    @NotBlank
    private final String operationHour;

    @NotBlank
    @Schema(description = "보호기간. '임시', '단기', '중장기' 중 하나로 요청해주세요.", defaultValue = "임시")
    private final String protectionPeriod;

    @NotBlank
    @Schema(description = "쉼터 타입. '여자 청소년만 입소 가능', '남자 청소년만 입소 가능', '모든 청소년 입소 가능' 중 하나로 요청해주세요.", defaultValue = "모든 청소년 입소 가능")
    private final String shelterType;

}
