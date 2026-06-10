package com.openlgu.shared.exception;

import java.time.Instant;

public class ErrorResponse {
    private String code;
    private String message;
    private String path;
    private String timestamp;

    public ErrorResponse(String code, String message, String path) {
        super();
        this.code = code;
        this.message = message;
        this.path = path;
        this.timestamp = Instant.now().toString();
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public String getTimestamp() {
        return timestamp;
    }

}
