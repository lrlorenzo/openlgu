package com.openlgu.resident.exception;

import java.util.UUID;

import com.openlgu.shared.exception.ApplicationException;
import com.openlgu.shared.exception.ErrorCode;

public class ResidentNotFoundException extends ApplicationException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ResidentNotFoundException(UUID id) {
        super(ErrorCode.RESIDENT_NOT_FOUND.getCode(), ErrorCode.RESIDENT_NOT_FOUND.getDefaultMessage() + id);
    }

}
