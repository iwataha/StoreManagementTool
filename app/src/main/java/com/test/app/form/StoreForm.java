package com.test.app.form;

import java.io.Serializable;

import com.test.app.model.User;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class StoreForm implements Serializable{
	
	@NotEmpty(message = "ユーザー名は必須です")
	private String storeName;
	
	@NotEmpty
	private String address;
	
	@Pattern(regexp = "^[0-9]{2,4}[0-9]{2,4}[0-9]{4}$|^$",message = "正しい形式で入力してください")
	@NotEmpty
	private String phoneNumber;
	
  	@NotEmpty
	private String openDate;
	
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
