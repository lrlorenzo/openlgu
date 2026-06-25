package com.openlgu.shared.exception;

public enum ErrorCode {
    DUPLICATE_KEY("RES-001", "Duplicate entry detected"),
    RESIDENT_NOT_FOUND("RES-100", "Resident not found: "),
    FILE_PROCESSING_ERROR("COM-100", "File Processing Error.");
	
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
