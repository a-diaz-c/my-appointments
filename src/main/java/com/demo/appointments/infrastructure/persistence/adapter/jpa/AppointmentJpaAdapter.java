package com.demo.appointments.infrastructure.persistence.adapter.jpa;

import com.demo.appointments.domain.dto.AppointmentDto;
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
    public List<AppointmentDto> getAppointments(LocalDate date) {
        List<AppointmentEntity> appointments = appointmentRepository.findByAppointmentDate(date);
        return appointments.stream().map(mapper::toDto).toList();
    }

    @Override
    public AppointmentDto createAppointment(AppointmentDto appointment) {
        var appointmentCreate = mapper.toDboCreate(appointment);
        return mapper.toDto(appointmentRepository.save(appointmentCreate));
    }
}
