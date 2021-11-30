package com.uncue_core.uncue.appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppoitmentRepository extends JpaRepository<Appointment,Integer> {

    @Query(value=" select appointment.appointmentid, appointment.saloonid," +
            " c.customerid,appointment.timeStamp as timestamp ,c.name as customername from appointment " +
            " inner join customer c on appointment.customerid = c.customerid where appointment.saloonid = ?1 " ,nativeQuery=true)
    List<AppointmentUpdateDto> getUpdateDto(int saloonId);


}
