package com.test.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.app.dto.StoreUserDto.StoreUserInfo;
import com.test.app.dto.UserAddStoreDto;
import com.test.app.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
	
	Store findByStoreName(String storeName);
	
	@Query(value = "SELECT users.user_name,stores.address,stores.store_name,stores.storeid,stores.phone_number,stores.open_date FROM stores LEFT JOIN users ON stores.user_id=users.id ;", nativeQuery = true)
	List<StoreUserInfo> findStoreUser();
	
	@Query(value = "SELECT stores.user_id,stores.address,stores.store_name,stores.storeid,stores.phone_number,stores.open_date FROM stores LEFT JOIN users ON stores.user_id=users.id WHERE users.id =:id ;", nativeQuery = true)
	List<Store> findStore(Long id);

	void save(UserAddStoreDto store);

}