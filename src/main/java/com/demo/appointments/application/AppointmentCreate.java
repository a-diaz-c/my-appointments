package com.demo.appointments.application;

import com.demo.appointments.application.mapper.AppointmentMapper;
import com.demo.appointments.domain.dto.AppointmentDto;
import com.demo.appointments.domain.dto.command.AppointmentCreateCommand;
import com.demo.appointments.domain.model.Appointment;
import com.demo.appointments.domain.port.IAppointment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AppointmentCreate {

    private final IAppointment appointmentPort;
    
    private final AppointmentMapper mapper;

    public AppointmentDto execute(AppointmentCreateCommand appointmentCommand){
    	Appointment appointment = new Appointment().toDomain(appointmentCommand);
        return mapper.toDto(appointmentPort.createAppointment(appointment));
    }
}
