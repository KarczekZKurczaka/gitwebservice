package com.pawel.webservice.exception;

public class AbstractGitHubException extends Exception {
    private final String code;

    public AbstractGitHubException(String message, String code, Exception e) {
        super(message, e);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
