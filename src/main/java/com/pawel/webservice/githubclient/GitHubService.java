package com.pawel.webservice.githubclient;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pawel.webservice.exception.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class GitHubService {
    private IGitHubClient client;

    @Value("${github.url}")
    private String serviceUrl;

    public GitHubRepository fetchRepository(String username, String repository) throws AbstractGitHubException {
        try {
            Response<GitHubRepository> response = client.fetchUsersRepository(username, repository).execute();
            switch (HttpStatus.resolve(response.code())) {
                case OK:
                    return response.body();
                case NOT_FOUND:
                    throw new GitHubRepositoryNotFoundException("GitHub Repository not found.", null);
                case BAD_REQUEST:
                    throw new ClientBadRequestException("GitHub Repository not found. Bad request.", null);
                case SERVICE_UNAVAILABLE:
                    throw new RemoteServiceException("Service Unavailable.", null);
                default:
                    throw new UnknownException("Unknown error.");

            }
        } catch (IOException e) {
            throw new RemoteServiceException("External Service Error", e);
        }
    }

    @PostConstruct
    public void buildGithubClient() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
        this.client = new Retrofit.Builder()
                .baseUrl(serviceUrl)
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .build().create(IGitHubClient.class);
    }
}
