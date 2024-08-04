package com.khackathon.nest.domain.shelter.exception;

import com.khackathon.nest.global.error.BusinessException;
import com.khackathon.nest.global.error.ErrorCode;

public class ProtectionPeriodNotFoundException extends BusinessException {

    public ProtectionPeriodNotFoundException() {
        super(ErrorCode.PROTECTION_PERIOD_NOT_FOUND);
    }

}
