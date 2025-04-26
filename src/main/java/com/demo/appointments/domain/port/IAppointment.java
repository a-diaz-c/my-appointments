package com.demo.appointments.domain.port;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.demo.appointments.domain.model.appointment.Appointment;
import com.demo.appointments.domain.model.user.User;

public interface IAppointment {

    public List<Appointment> getAppointments(LocalDate date);

    public Appointment createAppointment(Appointment appointment);
    
    public Appointment findAppointment(LocalDate date, LocalTime time);
    
    public List<Appointment> getAppointmentsByUser(User user);
}
