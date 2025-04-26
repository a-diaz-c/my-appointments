package com.demo.appointments.domain.port;

import com.demo.appointments.domain.model.user.User;

public interface IUser {

	public User createUser(User user);
	
	public User findById(Long id);
	
	public User findByEmail(String email);
}
