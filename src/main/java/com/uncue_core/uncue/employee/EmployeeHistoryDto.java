package com.uncue_core.uncue.employee;

import com.uncue_core.uncue.LobArray.IntegerArray;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Lob;

public interface EmployeeHistoryDto {

    String getAppointmentid();
    String getServiceName();
    int getServiceId();
    long getTimeStamp();
    int getCustomerid();
    String getCustomerName();


}
