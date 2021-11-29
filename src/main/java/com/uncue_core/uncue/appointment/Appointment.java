package com.uncue_core.uncue.appointment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Appointment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int appointmentid;
    long timeStamp;
    @Column(nullable = false)
    int saloonid;
    @Column(nullable = false)
    int customerid;
    int billid;
    String status;
    @ElementCollection
    List<AppointmentChild> appointmentChildList = new ArrayList<>();

}
