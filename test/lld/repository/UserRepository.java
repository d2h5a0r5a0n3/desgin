package com.learn.test.repository;

import com.learn.test.document.UserDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends ElasticsearchRepository<UserDocument,String> {
    Optional<UserDocument> findByEmail(String email);
}
