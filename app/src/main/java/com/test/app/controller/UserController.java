package com.test.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.app.dto.UpdateUserDto;
import com.test.app.model.Store;
import com.test.app.model.User;
import com.test.app.service.StorelistService;
import com.test.app.service.UserlistService;

@Controller
public class UserController {

	@Autowired
	private UserlistService userlistService;
	@Autowired
	private StorelistService storelistService;
	
	// ユーザー一覧表示
	@GetMapping("/user_list")
	public String user_list(Model model) {
		//List<UserStoreInfo> users = userlistService.getAllUsersAndStore();
		List<User> users = userlistService.getAllUsers();
		model.addAttribute("users", users);
		return "user_list";
	}

	// ユーザー編集画面へ遷移
	@GetMapping("/user/edit/{id}")
	public String editUser(@PathVariable Long id, Model model) {
		User user = userlistService.findById(id);
		model.addAttribute("user", user);
		return "update_user";
	}

	// 編集内容を送信
	@PostMapping("/user/update/{id}")
	public String updateUser(@PathVariable Long id, @ModelAttribute UpdateUserDto userDTO) {
		userlistService.updateUser(id, userDTO);
		return "update_success";
	}

	// ユーザーを削除
	@GetMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		userlistService.deleteById(id);
		return "redirect:/user_list";
	}
	
	//ユーザーの店舗一覧を表示
	@GetMapping("/user/store/{id}")
	public String storeShow(@PathVariable Long id, Model model) {
		List<Store> store = storelistService.findAllStore(id);
		model.addAttribute("store", store);
		if (store == null || store.size() == 0) {
			model.addAttribute("store_null", "対象店舗がありません");
		}
		
		return "user_store_show";
	}

}