package com.uncue_core.uncue.saloon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaloonRepository extends JpaRepository<Saloon,Integer> {
        List<Saloon> findAllByOrderBySaloonIdDesc();
}
