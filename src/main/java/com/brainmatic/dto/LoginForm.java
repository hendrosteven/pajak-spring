package com.brainmatic.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class LoginForm {
	
	private String email;
	
	private String password;
	
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
	
	
}
