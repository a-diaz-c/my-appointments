package com.demo.appointments.infrastructure.persistence.rest.controller;

import com.demo.appointments.application.AppointmentByDate;
import com.demo.appointments.application.AppointmentByUser;
import com.demo.appointments.application.AppointmentCreate;
import com.demo.appointments.domain.dto.AppointmentDto;
import com.demo.appointments.domain.dto.command.AppointmentCreateCommand;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentByDate appointmentByDate;
    private final AppointmentCreate appointmentCreate;
    private final AppointmentByUser appointmentByUser;

    @GetMapping()
    public List<AppointmentDto> getAppointments(@RequestParam String date) {
        return appointmentByDate.execute(date);
    }

    @PostMapping
    public AppointmentDto createAppointment(@RequestBody @Valid AppointmentCreateCommand appointment) {
        return appointmentCreate.execute(appointment);
    }
    
    @GetMapping("/user")
    public List<AppointmentDto> getAppointmentsByUser(@RequestParam Long userId){
    	return appointmentByUser.execute(userId);
    } 
}
