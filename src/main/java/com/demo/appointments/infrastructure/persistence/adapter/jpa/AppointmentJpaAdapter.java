package com.demo.appointments.infrastructure.persistence.adapter.jpa;

import com.demo.appointments.domain.model.Appointment;
import com.demo.appointments.domain.port.IAppointment;
import com.demo.appointments.infrastructure.persistence.adapter.entity.AppointmentEntity;
import com.demo.appointments.infrastructure.persistence.adapter.mapper.AppointmentDBMapper;
import com.demo.appointments.infrastructure.persistence.adapter.respostiory.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AppointmentJpaAdapter implements IAppointment {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentDBMapper mapper;

    @Override
    public List<Appointment> getAppointments(LocalDate date) {
        List<AppointmentEntity> appointments = appointmentRepository.findByAppointmentDate(date);
        List<Appointment> list =  appointments.stream().map(mapper::toDomain).toList();
        return list;
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        var appointmentCreate = mapper.toDboCreate(appointment);
        return mapper.toDomain(appointmentRepository.save(appointmentCreate));
    }
}
