package com.khackathon.nest.domain.shelter.exception;

import com.khackathon.nest.global.error.BusinessException;
import com.khackathon.nest.global.error.ErrorCode;

public class ProtectionPeriodNotFoundException extends BusinessException {

    public ProtectionPeriodNotFoundException() {
        super(ErrorCode.GRADE_NOT_FOUND);
    }

}
