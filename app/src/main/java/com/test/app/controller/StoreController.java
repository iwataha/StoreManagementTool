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

import com.test.app.dto.StoreUserDto.StoreUserInfo;
import com.test.app.model.Store;
import com.test.app.service.StorelistService;

@Controller
public class StoreController {

	@Autowired
	private StorelistService storelistService;

	// ストア一覧表示
	@GetMapping("/store_list")
	public String store_list(Model model) {
		List<StoreUserInfo> stores = storelistService.getAllStoreAndUser();
		model.addAttribute("stores", stores);
		return "store_list";
	}
	
	// ストア編集画面へ遷移
	@GetMapping("/store/edit/{storeid}")
	public String editStore(@PathVariable Long storeid, Model model) {
		Store store = storelistService.findById(storeid);
		model.addAttribute("store", store);
		return "update_store";
	}
	
    // 編集内容を送信
	@PostMapping("/store/update")
	public String updateStore(@ModelAttribute Store store, Model model) { 
		storelistService.updateStore(store); // ユーザー情報を更新
	return"update_success"; // 成功画面
	}
	
	@GetMapping("/store/delete/{storeid}")
	public String deleteUser(@PathVariable Long storeid, RedirectAttributes redirectAttributes) {
		storelistService.deleteById(storeid);
		return "redirect:/store_list";
	}
}
