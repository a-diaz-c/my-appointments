package com.demo.appointments.infrastructure.persistence.adapter.respostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.appointments.infrastructure.persistence.adapter.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	UserEntity findByEmail(String email);

}
