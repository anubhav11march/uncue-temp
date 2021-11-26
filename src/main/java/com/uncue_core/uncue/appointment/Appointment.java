package com.uncue_core.uncue.appointment;

import com.uncue_core.uncue.LobArray.IntegerArray;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Nullable;
import javax.persistence.*;
import java.io.Serializable;

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
    @Column(nullable = false)
    int employeeid;
    Float billid;
    String status;
    @Lob
    IntegerArray serviceid;

}
