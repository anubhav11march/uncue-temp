package com.uncue_core.uncue.appointment;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class AppointmentHistoryDto {
    int appointmentid;
    int customerid;
    long timestamp;
    String customername;
    int saloonid;
    List<Map<String, Object>> appointmentChild;
}
