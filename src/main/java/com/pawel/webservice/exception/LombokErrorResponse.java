package com.pawel.webservice.exception;

import lombok.Data;

@Data
public class LombokErrorResponse {
    private final String message;
    private final String errorCode;
    private final int httpCode;
}
