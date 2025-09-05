package com.test.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.form.StoreForm;
import com.test.app.model.Store;
import com.test.app.repository.StoreRepository;

import jakarta.transaction.Transactional;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Transactional
	
	public Store findByStoreName(String storeName) {
		return storeRepository.findByStoreName(storeName);
	}
	
	//ストア新規登録
	public void save(StoreForm storeForm) {
		Store store = new Store();
		store.setStoreName(storeForm.getStoreName());
		store.setAddress(storeForm.getAddress());
		store.setPhoneNumber(storeForm.getPhoneNumber());
		store.setOpenDate(storeForm.getOpenDate());
		store.setUser(storeForm.getUser());
		storeRepository.save(store);
	}

}
