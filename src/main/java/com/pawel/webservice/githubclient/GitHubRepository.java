package com.pawel.webservice.githubclient;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GitHubRepository {
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("clone_url")
    private String cloneUrl;
    @JsonProperty("stargazers_count")
    private int stars;
    @JsonProperty("created_at")
    private LocalDateTime creationDate;
    private String description;
}
