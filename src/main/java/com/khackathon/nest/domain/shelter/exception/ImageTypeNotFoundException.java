package com.khackathon.nest.domain.shelter.exception;

import com.khackathon.nest.global.error.BusinessException;
import com.khackathon.nest.global.error.ErrorCode;

public class ImageTypeNotFoundException extends BusinessException {

    public ImageTypeNotFoundException() {
        super(ErrorCode.IMAGE_TYPE_NOT_FOUND);
    }
}
