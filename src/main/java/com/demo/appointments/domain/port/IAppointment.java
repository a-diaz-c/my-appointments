package com.demo.appointments.domain.port;

import com.demo.appointments.domain.model.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface IAppointment {

    public List<Appointment> getAppointments(LocalDate date);

    public Appointment createAppointment(Appointment appointment);
}
