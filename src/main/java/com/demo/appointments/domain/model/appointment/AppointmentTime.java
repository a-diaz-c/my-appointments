package com.demo.appointments.domain.model.appointment;

import java.time.LocalTime;
import java.util.List;

import lombok.Getter;

@Getter
public class AppointmentTime {
	
	private  final List<Integer> validMinutes = List.of(0, 30);
	
	public AppointmentTime(LocalTime time) {
		
		if (!validMinutes.contains(time.getMinute())) {
		    throw new IllegalArgumentException("El minuto de la cita debe ser 0 o 30");
		}
		
		this.value = time;
		
	}
	
	private LocalTime value;
	

}
