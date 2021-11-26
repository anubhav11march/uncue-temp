package com.uncue_core.uncue.appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppoitmentRepository extends JpaRepository<Appointment,Integer> {

    List<Appointment> findBySaloonidOrderByAppointmentidDesc(int saloonId);
}
