package com.uncue_core.uncue.repository;

import com.uncue_core.uncue.collections.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {


    Optional<User> findByUid(String uid);
    Optional<User> findById(String id);
}
