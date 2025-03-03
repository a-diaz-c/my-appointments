package com.demo.appointments.domain.port;

import com.demo.appointments.domain.dto.AppointmentDto;

import java.time.LocalDate;
import java.util.List;

public interface IAppointment {

    public List<AppointmentDto> getAppointments(LocalDate date);

    public AppointmentDto createAppointment(AppointmentDto appointment);
}
