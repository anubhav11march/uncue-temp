package com.uncue_core.uncue.appointment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${BaseUrl}")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("${insertOrUpdateAppointment}")
    public Appointment insertAppointment(@RequestBody Appointment appointment) {

        return appointmentService.insertAppointment(appointment);




        }

    @GetMapping("${reteriveAppointments}")
    public List<Appointment> getAppointments(@PathVariable("saloonId") int saloonId) {


        return   appointmentService.getAppointments(saloonId);

    }

    @GetMapping("${reteriveAppointment}")
    public Appointment getAppointment(@PathVariable("appointmentid") int appointmentid) {
        return   appointmentService.getAppointment(appointmentid);

    }



}
