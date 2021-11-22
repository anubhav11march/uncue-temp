package com.uncue_core.uncue.Bill;

import com.uncue_core.uncue.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

//    List<Service> findBySaloonId(int uid);
//    Optional<Service> findByServiceId(int id);
//    void deleteByServiceId(int id);

}
