package com.test.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.app.dto.UserStoreDto.UserStoreInfo;
import com.test.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserName(String userName);

	@Query(value = "SELECT users.user_name, users.email,users.id,stores.address,stores.store_name FROM users LEFT JOIN stores ON users.id=stores.user_id;", nativeQuery = true)
	List<UserStoreInfo> findUserStore();
}