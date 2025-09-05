package com.test.app.dto;

import jakarta.validation.constraints.NotEmpty;

public class UpdateUserDto {
	
	@NotEmpty
	private String userName;
	
	@NotEmpty
	private String email;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}