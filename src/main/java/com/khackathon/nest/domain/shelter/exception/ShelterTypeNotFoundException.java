package com.khackathon.nest.domain.shelter.exception;

import com.khackathon.nest.global.error.BusinessException;
import com.khackathon.nest.global.error.ErrorCode;

public class ShelterTypeNotFoundException extends BusinessException {

    public ShelterTypeNotFoundException() {
        super(ErrorCode.SHELTER_TYPE_NOT_FOUND);
    }

}
