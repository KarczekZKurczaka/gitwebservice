package com.pawel.webservice.exception;

public class ClientBadRequestException extends AbstractGitHubException {
    public ClientBadRequestException(String message, Exception e) {
        super(message, ExceptionCode.BAD_REQUEST_EXCEPTION.getErrorCode(), e);
    }
}
