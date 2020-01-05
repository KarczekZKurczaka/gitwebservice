package com.pawel.webservice.exception;

public enum ExceptionCode {
    GITHUB_REPOSITORY_NOT_FOUND("github.repository.not.found"),
    EXTERNAL_SERVICE_ERROR("external.service.error"),
    BAD_REQUEST_EXCEPTION("github.bad.request"),
    UNKNOWN_ERROR("unknown.error");

    private String errorCode;

    ExceptionCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
