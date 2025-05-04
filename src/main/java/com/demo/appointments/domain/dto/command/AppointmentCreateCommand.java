package com.demo.appointments.domain.dto.command;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "El Nombre es obligatorio.")
    private String customerName;
    
    @NotNull(message = "El tipo de servicio es obligatorio.")
    private String serviceType;
    
    @NotNull(message = "La fecha es obligatoria.")
    @FutureOrPresent(message = "La fecha debe ser hoy o en el futuro.")
    private LocalDate appointmentDate;
    
    @NotNull(message = "La hora es obligatoria.")
    private LocalTime appointmentTime;

    private AppointmentStatusType status;
    
    @NotNull(message = "El ID del usuario es obligatorio.")
    private Long userId;

}
