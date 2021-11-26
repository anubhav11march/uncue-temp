package com.uncue_core.uncue.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer>, JpaSpecificationExecutor<Service> {
        List<Service> findBySaloonIdOrderByServiceIdDesc(int saloonid);
}
