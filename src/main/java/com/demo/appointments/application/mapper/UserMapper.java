package com.demo.appointments.application.mapper;

import org.springframework.stereotype.Component;

import com.demo.appointments.domain.dto.UserDto;
import com.demo.appointments.domain.model.user.User;

@Component
public class UserMapper {
	
	public UserDto toDto(User user) {
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		
		return dto;
	}

}
