package com.demo.appointments.domain.model.appointment;

import lombok.Getter;

@Getter
public class AppointmentDuration {
	
	private final Integer appointmentDuration = 30;
	
	public AppointmentDuration() {
		this.value = appointmentDuration;
	}
	
	private Integer value;

}
