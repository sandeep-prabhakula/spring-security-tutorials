package com.sandeepprabhakula.springsecuritytutorials.repository;

import com.sandeepprabhakula.springsecuritytutorials.data.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserInfo,String> {
    Optional<UserInfo> findByEmail(String email);
}
