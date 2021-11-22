package com.uncue_core.uncue.appointment;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int appointmentId;
    long timeStamp;
    int saloonId;
    int CustomerId;
    int EmployeeId;
    Float billId;
    String status;
    @ElementCollection
    List<Integer> serviceIds;


}
