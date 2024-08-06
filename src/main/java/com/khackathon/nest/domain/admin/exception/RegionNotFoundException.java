package com.khackathon.nest.domain.admin.exception;

import com.khackathon.nest.global.error.BusinessException;
import com.khackathon.nest.global.error.ErrorCode;

public class RegionNotFoundException extends BusinessException {

    public RegionNotFoundException() {
        super(ErrorCode.REGION_NOT_FOUND);
    }
}
