package com.brainmatic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.brainmatic.model.User;
import com.brainmatic.service.UserService;

@SpringBootApplication
public class DemoMvcApplication {
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		//Comments and comments
		SpringApplication.run(DemoMvcApplication.class, args);
	}
	
	@Bean
	public User createDefaultUser() {
		User user = userService.findByEmail("admin@gmail.com");
		if(user!=null) { 
			userService.removeUser(user);
		}
		user = new User();
		user.setFullName("Admin");
		user.setEmail("admin@gmail.com");
		user.setPassword("12345");
		return userService.register(user);
	}
}
