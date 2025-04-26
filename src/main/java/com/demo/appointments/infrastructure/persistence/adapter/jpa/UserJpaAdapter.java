package com.demo.appointments.infrastructure.persistence.adapter.jpa;

import org.springframework.stereotype.Component;

import com.demo.appointments.domain.model.user.User;
import com.demo.appointments.domain.port.IUser;
import com.demo.appointments.infrastructure.persistence.adapter.mapper.UserDBMapper;
import com.demo.appointments.infrastructure.persistence.adapter.respostiory.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserJpaAdapter implements IUser{
	
	private final UserRepository userRepository;
	private final UserDBMapper mapper;

	@Override
	public User createUser(User user) {
		var userCreate = mapper.toDbCreate(user);
		return mapper.toDomain(userRepository.save(userCreate));
	}

	@Override
	public User findById(Long id) {
		var user = userRepository.findById(id);
		
		if(user.isPresent()) {
			return mapper.toDomain(user.get());
		}
		
		return null;
	}

	@Override
	public User findByEmail(String email) {
		var user = userRepository.findByEmail(email);
		
		if(user != null) {
			return mapper.toDomain(user);
		}
		
		return null;
	}

}
