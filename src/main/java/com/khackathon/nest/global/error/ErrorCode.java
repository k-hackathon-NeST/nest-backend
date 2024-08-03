package com.khackathon.nest.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // Common
    INTERNAL_SERVER_ERROR(500, "C001", "서버에 오류가 발생하였습니다."),










    // Inquiry
    GRADE_NOT_FOUND(404, "I001", "해당하는 grade가 존재하지 않습니다.");










    // Shelter











    // Staff













    private final int status;
    private final String code;
    private final String message;
}
