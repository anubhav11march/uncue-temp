package com.uncue_core.uncue.appointment;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AppointmentService {
    @Autowired
    AppoitmentRepository repository;
    AppointmentHistoryDto childHistoryDto;
    @Autowired
    JdbcTemplate jdbcTemplate;


    public Appointment insertAppointment(Appointment appointmentDto) {

      return  repository.save(appointmentDto);

    }

    public List<AppointmentHistoryDto> getAppointments(int saloonId) {

        ModelMapper mapper = new ModelMapper();
        List<AppointmentUpdateDto> appointmentUpdateDtoList = repository.getUpdateDto(saloonId);
        List<AppointmentHistoryDto> historyDtos = new ArrayList<AppointmentHistoryDto>();
        AppointmentHistoryDto historyNewDto = null;
         for (AppointmentUpdateDto historyDto : appointmentUpdateDtoList)
         {
             String  sql = " select e.name as employeename,s.Name as servicename from appointment_appointmentchildlist " +
                     " inner JOIN  employee e on appointment_appointmentchildlist.employeeid = e.employeeid " +
                     " inner join service s on appointment_appointmentchildlist.serviceid = s.serviceId where Appointment_appointmentid= "+historyDto.getAppointmentid()+" ";
             List<Map<String, Object>> appointmentList =  jdbcTemplate.queryForList(sql);

             historyNewDto = mapper.map(historyDto, AppointmentHistoryDto.class);
             historyNewDto.setAppointmentChild(appointmentList);
            historyDtos.add(historyNewDto);
         }
        return historyDtos;
    }

    public Appointment getAppointment(int appointmentid) {
        return repository.findById(appointmentid).get();
    }


}
