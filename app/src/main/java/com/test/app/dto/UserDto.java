package com.test.app.dto;
import jakarta.validation.constraints.NotEmpty;

public class UserDto {
	@NotEmpty
	private String userName;
	@NotEmpty
	private String password;
	@NotEmpty
	private String email;
	@NotEmpty
	private Long storeid;
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getStoreid() {
		return storeid;
	}

	public void setStoreid(Long storeid) {
		this.storeid = storeid;
	}

}