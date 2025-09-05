package com.test.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.dto.UpdateUserDto;
import com.test.app.dto.UserStoreDto;
import com.test.app.dto.UserStoreDto.UserStoreInfo;
import com.test.app.model.Store;
import com.test.app.model.User;
import com.test.app.repository.StoreRepository;
import com.test.app.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserlistService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StoreRepository shopRepository;

	// ユーザー一覧を取得
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// ユーザー一覧と店舗情報を取得
	public List<UserStoreInfo> getAllUsersAndStore() {
		return userRepository.findUserStore();
	}

	// ユーザー情報を取得
	public User findById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	// 名前、メールアドレスを保存
	@Transactional
	public void updateUser(Long id, UpdateUserDto userDTO) {
		User user = userRepository.findById(id).orElse(null);
		if (user != null) {
			user.setUserName(userDTO.getUserName());
			user.setEmail(userDTO.getEmail());
			userRepository.save(user);
		}
	}

	// ユーザーを削除
	@Transactional
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
}