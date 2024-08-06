package com.khackathon.nest.domain.admin.exception;

import com.khackathon.nest.global.error.BusinessException;
import com.khackathon.nest.global.error.ErrorCode;

public class AdminNotFoundException extends BusinessException {

    public AdminNotFoundException() {
        super(ErrorCode.ADMIN_NOT_FOUND);
    }
}
