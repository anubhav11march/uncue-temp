package com.uncue_core.uncue.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {

//    List<Service> findBySaloonId(int uid);
//    Optional<Service> findByServiceId(int id);
//    void deleteByServiceId(int id);

}
