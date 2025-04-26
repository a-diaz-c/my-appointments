package com.demo.appointments.domain.exception;

public class UserNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(Long userId) {
        super("Usuario con ID " + userId + " no encontrado.");
    }

}
