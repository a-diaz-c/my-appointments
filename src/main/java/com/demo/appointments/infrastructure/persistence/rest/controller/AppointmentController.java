package com.demo.appointments.infrastructure.persistence.rest.controller;

import com.demo.appointments.application.AppointmentByDate;
import com.demo.appointments.application.AppointmentCreate;
import com.demo.appointments.domain.dto.AppointmentDto;
import com.demo.appointments.domain.dto.command.AppointmentCreateCommand;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentByDate appointmentByDate;
    private final AppointmentCreate appointmentCreate;

    @GetMapping("/{date}")
    public List<AppointmentDto> getAppointments(@PathVariable String date) {
        return appointmentByDate.execute(date);
    }

    @PostMapping
    public AppointmentDto createAppointment(@RequestBody AppointmentCreateCommand appointment) {
        return appointmentCreate.execute(appointment);
    }
}
