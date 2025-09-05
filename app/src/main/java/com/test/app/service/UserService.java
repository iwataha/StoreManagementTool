package com.test.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.app.dto.UserDto;
import com.test.app.model.Store;
import com.test.app.model.User;
import com.test.app.repository.StoreRepository;
import com.test.app.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private StoreRepository storeRepository;
	

	//既に登録済みの名前を参照
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new UserPrincipalService(user);
	}

	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	//ユーザー新規登録
	public void save(UserDto userDto) {
		
		User user = new User();
		user.setUserName(userDto.getUserName());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setEmail(userDto.getEmail());
		userRepository.save(user);
	}
	
	//ユーザー登録後、Storesテーブルにユーザーを登録
	public void saveStore(UserDto userDto) {
		
		//ユーザー登録されたUserNameからすべての値を取得
		User hoge = userRepository.findByUserName(userDto.getUserName());
		User user = new User();
		
		//hogeのIdを新しいユーザーのIdにセット
		user.setId(hoge.getId());
		
		//storeidに新しいユーザーのStoreIdをセット
		Long storeid = userDto.getStoreid();
		Store store = storeRepository.findById(storeid).orElse(null);
		
		//Storeにさっき取得したUserIdをセット
		store.setUser(user);
		storeRepository.save(store);
		
	}

}