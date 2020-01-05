package com.pawel.webservice.repo;

import com.pawel.webservice.githubclient.GitHubRepository;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IRepositoryMapper {

    Repository toRepository(GitHubRepository githubRepository);
}
