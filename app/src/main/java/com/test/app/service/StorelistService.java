package com.test.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.dto.StoreUserDto.StoreUserInfo;
import com.test.app.model.Store;
import com.test.app.repository.StoreRepository;

import jakarta.transaction.Transactional;

@Service
public class StorelistService {

	@Autowired
	private StoreRepository storeRepository;

	// 店舗一覧を取得
	public List<StoreUserInfo> getAllStoreAndUser() {
		return storeRepository.findStoreUser();
	}

	// 店舗更新用の店舗情報を取得
	public Store findById(Long id) {
		return storeRepository.findById(id).orElse(null);
	}

	// 店舗更新データを送信
	public void updateStore(Store store) {
		storeRepository.save(store);
	}

	// 店舗を削除
	@Transactional
	public void deleteById(Long id) {
		storeRepository.deleteById(id);
	}

	// ユーザーの店舗一覧を取得
	public List<Store> findAllStore(Long id) {
		List<Store> store = storeRepository.findStore(id);
		return store;
	}

}
