package com.demo.appointments.domain.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AppointmentDto implements Serializable {

    /**
     * @serial serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String customerName;
    private String serviceType;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;

    private String status;
}
