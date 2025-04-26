package com.demo.appointments.application;

import org.springframework.stereotype.Component;

import com.demo.appointments.application.mapper.UserMapper;
import com.demo.appointments.domain.dto.UserDto;
import com.demo.appointments.domain.dto.command.UserCreateCommand;
import com.demo.appointments.domain.exception.EmailAlreadyExistsException;
import com.demo.appointments.domain.model.user.User;
import com.demo.appointments.domain.port.IUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UserCreate {
	
	private final IUser userPort;
	private final UserMapper mapper;
	
	public UserDto excute(UserCreateCommand userCommand) {
		
		User userExisting = userPort.findByEmail(userCommand.getEmail());
		
		if(userExisting != null) {
			throw new EmailAlreadyExistsException(userCommand.getEmail());
		}
		
		User user = new User().toDomain(userCommand);	
		return mapper.toDto(userPort.createUser(user));
	}

}
