package com.pawel.webservice.exception;

public class GitHubRepositoryNotFoundException extends AbstractGitHubException {
    public GitHubRepositoryNotFoundException(String message, Exception e) {
        super(message, ExceptionCode.GITHUB_REPOSITORY_NOT_FOUND.getErrorCode(), e);
    }
}
