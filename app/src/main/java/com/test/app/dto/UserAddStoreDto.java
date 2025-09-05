package com.test.app.dto;

import com.test.app.model.User;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

public class UserAddStoreDto {
	
	@NotEmpty
	private Long storeid;
	
	@ManyToOne
	@JoinColumn(name = "user_id") // 外部キーのカラム名を指定
	private User user; // Userエンティティへの参照
	
	public interface UserAddStore {
		Long getUserId();
	}

	public Long getStoreid() {
		return storeid;
	}

	public void setStoreid(Long storeid) {
		this.storeid = storeid;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}