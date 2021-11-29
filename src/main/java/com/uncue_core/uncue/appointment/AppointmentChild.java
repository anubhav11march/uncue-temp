package com.uncue_core.uncue.appointment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Embeddable
public class AppointmentChild {
    int employeeid;
    int serviceid;
}
