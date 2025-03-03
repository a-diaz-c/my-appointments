package com.demo.appointments.infrastructure.persistence.adapter.mapper;

import com.demo.appointments.domain.dto.AppointmentDto;
import com.demo.appointments.infrastructure.persistence.adapter.entity.AppointmentEntity;
import org.springframework.stereotype.Component;

@Component
public class AppointmentDBMapper {

    public AppointmentDto toDto(AppointmentEntity appointment){

        if(appointment == null){
            return null;
        }

        return new AppointmentDto(appointment.getId(), appointment.getCustomerName(),
                appointment.getServiceType(), appointment.getAppointmentDate(), appointment.getAppointmentTime(),
                appointment.getStatus());
    }

    public AppointmentEntity toDboCreate(AppointmentDto appointmentDto){
        if(appointmentDto == null){
            return null;
        }

        return new AppointmentEntity(null, appointmentDto.getCustomerName(), appointmentDto.getServiceType(),
                appointmentDto.getAppointmentDate(), appointmentDto.getAppointmentTime(),
                appointmentDto.getStatus());
    }
}
