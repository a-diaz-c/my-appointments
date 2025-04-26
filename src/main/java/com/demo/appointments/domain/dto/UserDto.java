package com.demo.appointments.domain.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDto implements Serializable {

    /**
     * @serial serialVersionUID
     */
    private static final long serialVersionUID = 1L;
	
	private Long id;

    private String name;
    private String email;

}
