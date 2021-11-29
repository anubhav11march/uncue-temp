package com.uncue_core.uncue.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findBySaloonidOrderByEmployeeidDesc(int uid);

    @Query(value = "SELECT * FROM employee WHERE email=?1 and canLogin=true ", nativeQuery = true)
    Optional<Employee> findByemail(String username);

    Optional<List<Employee>> findByEmail(String username);

    @Query(value = "select appointment.`timeStamp`,s.name as serviceName,s.serviceId,appointment.appointmentid,c.name,c.customerid,c.name as customerName from appointment " +
            " inner join appointment_appointmentchildlist aa on appointment.appointmentid = aa.Appointment_appointmentid " +
            " inner join service s on aa.serviceid = s.serviceId " +
            " inner join customer c on appointment.customerid = c.customerid  " +
            " where aa.employeeid = ?1 ",nativeQuery=true)
    List<EmployeeHistoryDto> getEmployeeHistory(int employeeid);


}
