package com.demo.appointments.application.mapper;

import com.demo.appointments.domain.dto.AppointmentDto;
import com.demo.appointments.domain.model.appointment.Appointment;


public interface IAppointmentMapper {
	
	/*@Mapping(source = "id", target = "id")
	@Mapping(source = "customerName", target = "customerName")
	@Mapping(source = "serviceType", target = "serviceType")
	@Mapping(source = "appointmentDate", target = "appointmentDate")
	@Mapping(source = "appointmentTime", target = "appointmentTime")
	@Mapping(source = "status", target = "status")*/
	public AppointmentDto toDto(Appointment appointment);

}
