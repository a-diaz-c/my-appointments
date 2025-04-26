package com.demo.appointments.domain.exception;

public class EmailAlreadyExistsException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailAlreadyExistsException(String email) {
        super("Ya existe un usuario con el correo: " + email);
    }

}
