package com.pawel.webservice.githubclient;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IGitHubClient {

    @GET("repos/{username}/{repoName}")
    Call<GitHubRepository> fetchUsersRepository(@Path("username") String username, @Path("repoName") String repositoryName);
}
