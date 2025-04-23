package com.demo.appointments.domain.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AppointmentDate {
	
	private LocalDate value;

}
