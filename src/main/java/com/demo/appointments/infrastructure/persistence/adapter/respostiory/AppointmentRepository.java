package com.demo.appointments.infrastructure.persistence.adapter.respostiory;

import com.demo.appointments.infrastructure.persistence.adapter.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {

    List<AppointmentEntity> findByAppointmentDate(LocalDate date);
}
