package com.demo.appointments.infrastructure.persistence.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.appointments.application.UserCreate;
import com.demo.appointments.application.UserRetrive;
import com.demo.appointments.domain.dto.UserDto;
import com.demo.appointments.domain.dto.command.UserCreateCommand;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserCreate userCreate;
	
	private final UserRetrive userRetrive;
	
	@PostMapping
	public UserDto createUser(@RequestBody UserCreateCommand user) {
		return userCreate.excute(user);
	}
	
	@GetMapping("/{id}")
	public UserDto getUserById(@PathVariable Long id) {
		return userRetrive.excute(id);
	}

}
