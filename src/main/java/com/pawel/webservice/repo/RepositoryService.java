package com.pawel.webservice.repo;

import com.pawel.webservice.exception.AbstractGitHubException;
import com.pawel.webservice.githubclient.GitHubService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RepositoryService {

    private final GitHubService githubService;
    private final IRepositoryMapper mapper;

    public Repository fetchRepository(String username, String repositoryName) throws AbstractGitHubException {
        return mapper.toRepository(githubService.fetchRepository(username, repositoryName));
    }


}
