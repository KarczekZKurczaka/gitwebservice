package com.pawel.webservice.exception;

public class UnknownException extends AbstractGitHubException {
    public UnknownException(String message) {
        super(message, ExceptionCode.UNKNOWN_ERROR.getErrorCode(), null);
    }
}
