package com.demo.appointments.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.demo.appointments.domain.dto.command.AppointmentCreateCommand;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Appointment {

	private AppointmentId id;
	private AppointmentCustomerName customerName;
	private AppointmentServiceType serviceType;
	private AppointmentDate appointmentDate;
	private AppointmentTime appointmentTime;

	private AppointmentStatus status;

	public Appointment(Long id, String customerName, String serviceType, LocalDate appointmentDate,
			LocalTime appointmentTime, String status) {
		this.id = new AppointmentId(id);
		this.customerName = new AppointmentCustomerName(customerName);
		this.serviceType = new AppointmentServiceType(serviceType);
		this.appointmentDate = new AppointmentDate(appointmentDate);
		this.appointmentTime = new AppointmentTime(appointmentTime);
		this.status = new AppointmentStatus(status);

	}

	public Long getId() {
		return id.getValue();
	}

	public String getCustomerName() {
		return customerName.getValue();
	}

	public String getServiceType() {
		return serviceType.getValue();
	}
	
	public LocalDate getAppointmentDate() {
		return appointmentDate.getValue();
	}

	public LocalTime getAppointmentTime() {
		return appointmentTime.getValue();
	}

	public String getStatus() {
		return status.getValue();
	}
	
    public Appointment toDomain(AppointmentCreateCommand appointment ) {
    	this.customerName = new AppointmentCustomerName(appointment.getCustomerName());
    	this.serviceType = new AppointmentServiceType(appointment.getServiceType());
    	this.appointmentDate = new AppointmentDate(appointment.getAppointmentDate());
    	this.appointmentTime = new AppointmentTime(appointment.getAppointmentTime());
    	this.status = new AppointmentStatus(appointment.getStatus());
    
    	return this;
    }

}
