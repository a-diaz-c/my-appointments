package com.demo.appointments.domain.model.appointment;

import java.time.LocalTime;
import java.util.List;

import lombok.Getter;

@Getter
public class AppointmentTime {
	
	private final List<Integer> validMinutes = List.of(0, 30);
	private final int openingHour = 10; 
	private final int closingHour = 18; 
	
	private LocalTime value;
	
	public AppointmentTime(LocalTime time) {
		
		validateMinutes(time.getMinute());
		validateTime(time);
		
		this.value = time;
		
	}
	
	private void validateMinutes(int minute) {
		if (!validMinutes.contains(minute)) {
		    throw new IllegalArgumentException("El minuto de la cita debe ser 0 o 30");
		}
	}
	
	private void validateTime(LocalTime time) {
		
		LocalTime openingTime = LocalTime.of(openingHour, 0);
	    LocalTime closingTime = LocalTime.of(closingHour, 0);
	    
	    if(time.isBefore(openingTime) || time.isAfter(closingTime)) {
	    	throw new IllegalArgumentException("La hora debe estar entre 10:00 y 18:00.");
	    }
	}
	

}
