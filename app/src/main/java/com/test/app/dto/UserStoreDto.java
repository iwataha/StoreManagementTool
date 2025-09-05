package com.test.app.dto;

import jakarta.validation.constraints.NotEmpty;

public class UserStoreDto {
	@NotEmpty
	private String userName;
	@NotEmpty
	private Long id;
	@NotEmpty
	private String email;
	@NotEmpty
	private String storeName;
	@NotEmpty
	private String address;
	
	public interface UserStoreInfo {
	    String getUserName();
	    Long getId();
	    String getEmail();
	    String getStoreName();
	    String getAddress();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	public String getAdress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}