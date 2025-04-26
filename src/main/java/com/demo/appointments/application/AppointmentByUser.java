package com.demo.appointments.application;

import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.appointments.application.mapper.AppointmentMapper;
import com.demo.appointments.domain.dto.AppointmentDto;
import com.demo.appointments.domain.exception.UserNotFoundException;
import com.demo.appointments.domain.model.user.User;
import com.demo.appointments.domain.port.IAppointment;
import com.demo.appointments.domain.port.IUser;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AppointmentByUser {

	private final IAppointment appointment;
	
	private final IUser userPort;

	private final AppointmentMapper mapper;

	public List<AppointmentDto> execute(Long id){
		
		User user = userPort.findById(id);
		
		if(user == null) {
			throw new UserNotFoundException(id);
		}
		
		List<AppointmentDto> list = appointment.getAppointmentsByUser(user).stream()
				.map(mapper::toDto).toList();
		
		return list;
	}

}
