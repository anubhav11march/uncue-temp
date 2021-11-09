package com.uncue_core.uncue.repository;

import com.uncue_core.uncue.collections.Service;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServiceRepository extends MongoRepository<Service, String> {
}
