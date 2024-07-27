package com.khackathon.nest.domain.inquiry.exception;

import com.khackathon.nest.global.error.BusinessException;
import com.khackathon.nest.global.error.ErrorCode;

public class InvalidInquiryException extends BusinessException {

    public InvalidInquiryException() {
        super(ErrorCode.INVALID_INQUIRY);
    }
}
