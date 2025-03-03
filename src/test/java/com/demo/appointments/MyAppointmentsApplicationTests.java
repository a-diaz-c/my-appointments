package com.demo.appointments;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MyAppointmentsApplicationTests {

	@Test
	void contextLoads() {
		boolean myAppointments = true;
		assertTrue(myAppointments);
	}

}
