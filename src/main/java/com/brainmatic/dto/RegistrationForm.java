package com.brainmatic.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class RegistrationForm {
	
	@NotEmpty(message="Email is required")
	@Email(message="Invalid email address")
	private String email;
	
	@NotEmpty(message = "Password is required")
	private String password;
	
	@NotEmpty(message = "Full Name is required")
	private String fullName;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
}
