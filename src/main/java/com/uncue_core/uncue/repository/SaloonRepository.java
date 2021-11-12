package com.uncue_core.uncue.repository;

import com.uncue_core.uncue.collections.Saloon;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SaloonRepository extends MongoRepository<Saloon, String> {

    Optional<Saloon> findByUid(String uid);
    Optional<Saloon> findBySaloonId(String id);
}
