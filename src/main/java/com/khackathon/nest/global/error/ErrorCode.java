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
    SHELTER_NOT_FOUND(404, "S003", "해당하는 쉼터가 존재하지 않습니다."),
    IMAGE_TYPE_NOT_FOUND(404, "S004", "해당하는 이미지 type이 존재하지 않습니다."),










    // Admin
    REGION_NOT_FOUND(404, "A001", "해당하는 지역(소속)이 존재하지 않습니다."),
    ADMIN_NOT_FOUND(404, "A002", "로그인 정보에 해당하는 사용자가 존재하지 않습니다.");












    private final int status;
    private final String code;
    private final String message;
}
