package com.demo.appointments.infrastructure.persistence.adapter.respostiory;

import com.demo.appointments.infrastructure.persistence.adapter.entity.AppointmentEntity;
import com.demo.appointments.infrastructure.persistence.adapter.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {

    List<AppointmentEntity> findByAppointmentDate(LocalDate date);
    
    AppointmentEntity findByAppointmentDateAndAppointmentTime(LocalDate date, LocalTime time);
    
    List<AppointmentEntity> findByUser(UserEntity user);
}
