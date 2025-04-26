package com.demo.appointments.application;

import org.springframework.stereotype.Component;

import com.demo.appointments.application.mapper.UserMapper;
import com.demo.appointments.domain.dto.UserDto;
import com.demo.appointments.domain.exception.UserNotFoundException;
import com.demo.appointments.domain.port.IUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UserRetrive {
	
	private final IUser userPort;
	private final UserMapper mapper;
	
	public UserDto excute(Long id) {
		
		var user = userPort.findById(id);
		
		if(user == null) {
			throw new UserNotFoundException(id);
		}
		
		return mapper.toDto(userPort.findById(id));
	}

}
