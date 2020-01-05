package com.pawel.webservice.exception;

public class RemoteServiceException extends AbstractGitHubException {
    public RemoteServiceException(String message, Exception e) {
        super(message, ExceptionCode.EXTERNAL_SERVICE_ERROR.getErrorCode(), e);
    }
}
