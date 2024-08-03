package com.khackathon.nest.domain.inquiry.exception;

import com.khackathon.nest.global.error.BusinessException;
import com.khackathon.nest.global.error.ErrorCode;

public class GradeNotFoundException extends BusinessException {

    public GradeNotFoundException() {
        super(ErrorCode.GRADE_NOT_FOUND);
    }
}
