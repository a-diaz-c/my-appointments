package com.demo.appointments.domain.model.user;

import com.demo.appointments.domain.dto.command.UserCreateCommand;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class User {
	
	private UserId id;
    private UserName name;
    private UserEmail email;
    
    public User(Long id, String name, String email) {
    	this.id = new UserId(id);
    	this.name = new UserName(name);
    	this.email = new UserEmail(email);
    }

	public Long getId() {
		return id.getValue();
	}

	public String getName() {
		return name.getValue();
	}

	public String getEmail() {
		return email.getValue();
	}
    
	public User toDomain(UserCreateCommand user) {
		this.id = new UserId(user.getId());
		this.name = new UserName(user.getName());
		this.email = new UserEmail(user.getEmail());
		
		return this;
	}
    
}
