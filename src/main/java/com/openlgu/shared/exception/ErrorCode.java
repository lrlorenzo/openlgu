package com.openlgu.shared.exception;

public enum ErrorCode {
    
    RESIDENT_NOT_FOUND("RES-100", "Resident not found: ");
    
    ErrorCode(String code, String message) {
        this.code = code;
        this.defaultMessage = message;
    }

    private final String code;
    private final String defaultMessage;
    
    public String getCode() {
        return code;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }
    
}
