package com.uncue_core.uncue.Bill;


import com.uncue_core.uncue.appointment.AppoitmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    @Autowired
    BillRepository repository;

    // get by customer
    //

    public Bill insertBIll(Bill appointment) {
        return repository.save(appointment);
    }

    public List<Bill> getBIlls(int saloonId) {
        return repository.findBySaloonIdOrderByBillIdDesc(saloonId);
    }

    public Bill getBIll(int appointmentid) {
        return repository.findById(appointmentid).get();
    }
}
