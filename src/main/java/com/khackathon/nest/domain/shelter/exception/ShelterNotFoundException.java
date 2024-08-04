package com.khackathon.nest.domain.shelter.exception;

import com.khackathon.nest.global.error.BusinessException;
import com.khackathon.nest.global.error.ErrorCode;

public class ShelterNotFoundException extends BusinessException {

    public ShelterNotFoundException() {
        super(ErrorCode.SHELTER_NOT_FOUND);
    }
}
