package com.test.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.test.app.dto.UserDto;
import com.test.app.model.Store;
import com.test.app.model.User;
import com.test.app.service.UserService;

@Controller
public class RegisterController {
	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String registerForm() {
		return "register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute UserDto userDto) {
		User existing = userService.findByUserName(userDto.getUserName());
		if (existing != null) {
			return "register";
		}
		
		userService.save(userDto);
		
		//userDto.getStoreid();
		userService.saveStore(userDto);
		
		return "login";
	}
}