package com.demo.appointments.infrastructure.persistence.adapter.jpa;

import com.demo.appointments.domain.model.appointment.Appointment;
import com.demo.appointments.domain.model.user.User;
import com.demo.appointments.domain.port.IAppointment;
import com.demo.appointments.infrastructure.persistence.adapter.entity.AppointmentEntity;
import com.demo.appointments.infrastructure.persistence.adapter.mapper.AppointmentDBMapper;
import com.demo.appointments.infrastructure.persistence.adapter.mapper.UserDBMapper;
import com.demo.appointments.infrastructure.persistence.adapter.respostiory.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AppointmentJpaAdapter implements IAppointment {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentDBMapper mapper;
    private final UserDBMapper userMapper;

    @Override
    public List<Appointment> getAppointments(LocalDate date, String status) {
        List<AppointmentEntity> appointments = appointmentRepository.findByAppointmentDateAndStatus(date, status);
        List<Appointment> list =  appointments.stream().map(mapper::toDomain).toList();
        return list;
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        var appointmentCreate = mapper.toDboCreate(appointment);
        return mapper.toDomain(appointmentRepository.save(appointmentCreate));
    }
    
    @Override
    public Appointment findAppointment(LocalDate date, LocalTime time) {
    	var appointments = appointmentRepository.findByAppointmentDateAndAppointmentTime(date, time);
    	return mapper.toDomain(appointments);
    }

	@Override
	public List<Appointment> getAppointmentsByUser(User user) {
		var appointmentCreate = userMapper.toDbCreate(user);
		return appointmentRepository.findByUser(appointmentCreate).stream()
				.map(mapper::toDomain).toList();
	}
}
