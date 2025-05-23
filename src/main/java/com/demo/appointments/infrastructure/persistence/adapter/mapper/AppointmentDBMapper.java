package com.demo.appointments.infrastructure.persistence.adapter.mapper;

import com.demo.appointments.domain.model.Appointment;
import com.demo.appointments.infrastructure.persistence.adapter.entity.AppointmentEntity;
import org.springframework.stereotype.Component;

@Component
public class AppointmentDBMapper {

    public Appointment toDomain(AppointmentEntity appointment){

        if(appointment == null){
            return null;
        }

        return new Appointment(appointment.getId(), appointment.getCustomerName(),
                appointment.getServiceType(), appointment.getAppointmentDate(), appointment.getAppointmentTime(),
                appointment.getStatus());
    }

    public AppointmentEntity toDboCreate(Appointment appointmentDto){
        if(appointmentDto == null){
            return null;
        }

        return new AppointmentEntity(null, appointmentDto.getCustomerName(), appointmentDto.getServiceType(),
                appointmentDto.getAppointmentDate(), appointmentDto.getAppointmentTime(),
                appointmentDto.getStatus());
    }
}
