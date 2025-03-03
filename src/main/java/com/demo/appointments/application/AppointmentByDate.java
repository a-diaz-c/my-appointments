package com.demo.appointments.application;

import com.demo.appointments.domain.dto.AppointmentDto;
import com.demo.appointments.domain.port.IAppointment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Component
public class AppointmentByDate {

    private final IAppointment appointment;

    public List<AppointmentDto> execute(String date){
        return appointment.getAppointments(LocalDate.parse(date));
    }
}
