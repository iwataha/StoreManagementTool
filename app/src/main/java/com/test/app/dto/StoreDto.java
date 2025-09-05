package com.test.app.dto;

import com.test.app.model.User;

import jakarta.validation.constraints.NotEmpty;

public class StoreDto {

	@NotEmpty
	private String storeName;
	
	@NotEmpty
	private String address;
	
	@NotEmpty
	private String phoneNumber;
	
	@NotEmpty
	private String openDate;
	
	@NotEmpty
	private User user;

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
