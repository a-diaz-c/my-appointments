package com.demo.appointments.application.mapper;

import org.springframework.stereotype.Component;

import com.demo.appointments.domain.dto.AppointmentDto;
import com.demo.appointments.domain.model.appointment.Appointment;

@Component
public class AppointmentMapper {
	
	
	public AppointmentDto toDto(Appointment appointment) {
		AppointmentDto dto = new AppointmentDto();
		dto.setId(appointment.getId());
		dto.setCustomerName(appointment.getCustomerName());
		dto.setServiceType(appointment.getServiceType());
		dto.setAppointmentDate(appointment.getAppointmentDate());
		dto.setAppointmentTime(appointment.getAppointmentTime());
		dto.setStatus(appointment.getStatus());
		
		return dto;
	}

}
