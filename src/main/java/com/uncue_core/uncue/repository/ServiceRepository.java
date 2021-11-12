package com.uncue_core.uncue.repository;

import com.uncue_core.uncue.collections.Service;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository extends MongoRepository<Service, String> {

    List<Service> findBySaloonId(String uid);
    Optional<Service> findByServiceId(String id);
    void deleteByServiceId(String id);

}
