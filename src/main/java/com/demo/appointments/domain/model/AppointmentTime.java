package com.demo.appointments.domain.model;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AppointmentTime {
	
	private LocalTime value;

}
