package com.demo.appointments.application;

import com.demo.appointments.domain.dto.AppointmentDto;
import com.demo.appointments.domain.port.IAppointment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AppointmentCreate {

    private final IAppointment appointment;

    public AppointmentDto execute(AppointmentDto appointmentdto){
        return appointment.createAppointment(appointmentdto);
    }
}
