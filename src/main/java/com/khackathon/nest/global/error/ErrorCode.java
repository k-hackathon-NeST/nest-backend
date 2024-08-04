package com.khackathon.nest.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // Common
    INTERNAL_SERVER_ERROR(500, "C001", "서버에 오류가 발생하였습니다."),










    // Inquiry
    GRADE_NOT_FOUND(404, "I001", "해당하는 grade가 존재하지 않습니다."),










    // Shelter
    PROTECTION_PERIOD_NOT_FOUND(404, "S001", "해당하는 보호기간이 존재하지 않습니다."),
    SHELTER_TYPE_NOT_FOUND(404, "S002", "해당하는 쉼터의 type이 존재하지 않습니다."),
    SHELTER_NOT_FOUND(404, "S003", "해당하는 쉼터가 존재하지 않습니다.");










    // Staff













    private final int status;
    private final String code;
    private final String message;
}
