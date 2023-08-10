package com.sandeepprabhakula.springsecurityjwt.repository;

import com.sandeepprabhakula.springsecurityjwt.data.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends MongoRepository<UserInfo,String> {
    Optional<UserInfo>findByEmail(String email);
}
