package com.demo.appointments.application;

import com.demo.appointments.application.mapper.AppointmentMapper;
import com.demo.appointments.domain.dto.AppointmentDto;
import com.demo.appointments.domain.dto.command.AppointmentCreateCommand;
import com.demo.appointments.domain.exception.UserNotFoundException;
import com.demo.appointments.domain.model.appointment.Appointment;
import com.demo.appointments.domain.model.user.User;
import com.demo.appointments.domain.port.IAppointment;
import com.demo.appointments.domain.port.IUser;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AppointmentCreate {

    private final IAppointment appointmentPort;
    
    private final IUser userPort;
    
    private final AppointmentMapper mapper;

    public AppointmentDto execute(AppointmentCreateCommand appointmentCommand){
    	
    	Appointment existingAppointment = appointmentPort.findAppointment(appointmentCommand.getAppointmentDate(), 
    			appointmentCommand.getAppointmentTime());
    	
    	if(existingAppointment != null) {
    		throw new IllegalStateException("Este lugar ya está reservado para esa fecha y hora.");
    	}
    	
    	User user = userPort.findById(appointmentCommand.getUserId());
    	
    	if(user == null) {
    		throw new UserNotFoundException(appointmentCommand.getUserId());
    	}
    	
    	Appointment appointment = new Appointment().toDomain(appointmentCommand, user);

        return mapper.toDto(appointmentPort.createAppointment(appointment));
    }
    
    private void validateNoOverlap(LocalDate date, LocalTime time) {
    	LocalTime start = time;
        LocalTime end = start.plusMinutes(30);
        
        List<Appointment> existingAppointments = appointmentPort.getAppointments(date);
        
        existingAppointments.stream().forEach(appointment -> {
        	LocalTime existingStart = appointment.getAppointmentTime();
            LocalTime existingEnd = existingStart.plusMinutes(appointment.getDuration());
            
            boolean overlaps = !(end.isBefore(existingStart) || start.isAfter(existingEnd));
            
            if (overlaps) {
                throw new IllegalStateException("Ya hay una cita que se cruza con este horario.");
            }

        });
    }
}
