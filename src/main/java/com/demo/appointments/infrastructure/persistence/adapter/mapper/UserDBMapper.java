package com.demo.appointments.infrastructure.persistence.adapter.mapper;

import org.springframework.stereotype.Component;

import com.demo.appointments.domain.model.user.User;
import com.demo.appointments.infrastructure.persistence.adapter.entity.UserEntity;

@Component
public class UserDBMapper {
	
	public User toDomain(UserEntity user) {
		
		if(user == null) {
			return null;
		}
		
		return new User(user.getId(), user.getName(), user.getEmail());
	}
	
	public UserEntity toDbCreate(User user) {
		
		if(user == null) {
			return null;
		}
		
		return new UserEntity(user.getId(), user.getName(), user.getEmail(), null);
		
	}

}
