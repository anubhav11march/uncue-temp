package com.uncue_core.uncue.saloon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SaloonRepository extends JpaRepository<Saloon, Integer> {


}
