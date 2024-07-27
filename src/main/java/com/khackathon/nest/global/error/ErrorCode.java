package com.khackathon.nest.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // Common
    INTERNAL_SERVER_ERROR(500, "C001", "서버에 오류가 발생하였습니다."),










    // Inquiry
    INVALID_INQUIRY(400, "I001", "문의글 요청 값이 유효하지 않습니다.");










    // Shelter











    // Staff













    private final int status;
    private final String code;
    private final String message;
}
