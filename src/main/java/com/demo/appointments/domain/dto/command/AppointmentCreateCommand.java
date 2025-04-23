package com.demo.appointments.domain.dto.command;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class AppointmentCreateCommand implements Serializable{
	
	/**
     * @serial serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String customerName;
    private String serviceType;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;

    private String status = "scheduled";

}
