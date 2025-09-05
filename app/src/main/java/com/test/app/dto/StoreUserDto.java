package com.test.app.dto;

import jakarta.validation.constraints.NotEmpty;

public class StoreUserDto {

	@NotEmpty
	private String storeName;

	@NotEmpty
	private String address;

	@NotEmpty
	private String phoneNumber;

	@NotEmpty
	private String openDate;

	@NotEmpty
	private String userName;

	@NotEmpty
	private Long storeId;

	public interface StoreUserInfo {
		
		String getUserName();

		String getStoreName();

		String getPhoneNumber();

		String getAddress();

		String getOpenDate();

		String getStoreId();
	}

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

	public String getUserName() {
		return userName;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getStoreId() {
		return storeId;
	}
}
