package com.pawel.webservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({RemoteServiceException.class, UnknownException.class})
    protected ResponseEntity<Object> handleRemoteServiceIssues(AbstractGitHubException ex, WebRequest request) {
        return handleException(ex, request, SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(GitHubRepositoryNotFoundException.class)
    protected ResponseEntity<Object> handleNotFoundIssue(AbstractGitHubException ex, WebRequest request) {
        return handleException(ex, request, NOT_FOUND);
    }

    @ExceptionHandler(ClientBadRequestException.class)
    protected ResponseEntity<Object> handleBadRequest(AbstractGitHubException ex, WebRequest request) {
        return handleException(ex, request, BAD_REQUEST);
    }

    private ResponseEntity<Object> handleException(AbstractGitHubException ex, WebRequest request, HttpStatus status) {
        return handleExceptionInternal(ex, getResponseBody(ex, status),
                new HttpHeaders(), status, request);
    }

    private LombokErrorResponse getResponseBody(AbstractGitHubException ex, HttpStatus httpStatus) {
        return new LombokErrorResponse(ex.getMessage(), ex.getCode(), httpStatus.value());
    }
}
