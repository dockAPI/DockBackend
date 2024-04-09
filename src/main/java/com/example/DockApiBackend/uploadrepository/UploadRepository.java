package com.example.DockApiBackend.uploadrepository;

import com.example.DockApiBackend.Modals.Dockapi;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UploadRepository extends MongoRepository<Dockapi,Integer> {
    boolean existsByGithubId(int githubId);
    Dockapi findByGithubId(int githubId);
    void deleteByGithubId(int githubId);
}
