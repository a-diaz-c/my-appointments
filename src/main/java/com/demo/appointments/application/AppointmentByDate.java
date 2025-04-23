package com.demo.appointments.application;

import com.demo.appointments.application.mapper.AppointmentMapper;
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
    
    private final AppointmentMapper mapper;

    public List<AppointmentDto> execute(String date){
    	List<AppointmentDto> list = appointment.getAppointments(LocalDate.parse(date)).stream()
        		.map(mapper::toDto).toList();
    	
    	return list;
    }
}
